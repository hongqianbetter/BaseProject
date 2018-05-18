package net.better.hongqian.baseproject;

import android.text.TextUtils;

import net.better.hongqian.baseproject.logger.HttpLogger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HongQian.Wang on 2018/2/26.
 */

public class Network {

    private static final long DEFAULT_CONNECT_TIME = 20;
    private static final long DEFAULT_WRITE_TIME = 20;
    private static final long DEFAULT_READ_TIME = 20;
    private static Network instance;
    private Retrofit retrofit;
    private OkHttpClient client;
    private HttpLoggingInterceptor logInterceptor;

    static {
        instance = new Network();
    }

    private Network() {
    }

    public static OkHttpClient getClient() {
        if (instance.client != null) return instance.client;

        // 存储起来
        instance.client = new OkHttpClient.Builder()
            .addNetworkInterceptor(getLogIntercepotor())
                // 给所有的请求添加一个拦截器
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        // 拿到我们的请求
                        Request original = chain.request();
                        // 重新进行build
                        Request.Builder builder = original.newBuilder();
                        if (!TextUtils.isEmpty(Account.getToken())) {
                            // 注入一个token
                            builder.addHeader("token", Account.getToken());  //添加公共参数
                        }
                        builder.addHeader("Content-Type", "application/json");
                        Request newRequest = builder.build();
                        // 返回
                        return chain.proceed(newRequest);
                    }
                })
                .connectTimeout(DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIME,TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME,TimeUnit.SECONDS)
                .build();
        return instance.client;
    }


    //     构建一个Retrofit
    public static Retrofit getRetrofit() {
        if (instance.retrofit != null) return instance.retrofit;

        // 得到一个OK Client
        OkHttpClient client = getClient();

        // Retrofit
        Retrofit.Builder builder = new Retrofit.Builder();

        // 设置电脑链接
        instance.retrofit = builder.baseUrl("http://api.julyedu.com/")
//        instance.retrofit = builder.baseUrl(Common.Constance.API_URL)
                // 设置client
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                // 设置Json解析器
                .addConverterFactory(GsonConverterFactory.create(Factory.getGson()))
                .build();

        return instance.retrofit;

    }

    public static HttpLoggingInterceptor getLogIntercepotor() {
        if(instance.logInterceptor!=null) {
            return instance.logInterceptor;
        }
        instance.logInterceptor=new HttpLoggingInterceptor(new HttpLogger());
        if (BuildConfig.DEBUG) {
            //显示日志
            instance.logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            instance.logInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return instance.logInterceptor;

    }


    public static RemoteService remote() {
        return getRetrofit().create(RemoteService.class);
    }


}
