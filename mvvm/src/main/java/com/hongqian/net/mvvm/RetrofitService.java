package com.hongqian.net.mvvm;

import android.provider.SyncStateContract;
import android.text.TextUtils;

import java.nio.charset.Charset;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Create by HongQian.better on ${DATA}
 **/
public class RetrofitService {


    /**
     * 打印返回的json数据拦截器
     */
    public static final Interceptor sLoggingInterceptor = chain -> {
        final Request request = chain.request();
        Buffer requestBuffer = new Buffer();
        if (request.body() != null) {
            request.body().writeTo(requestBuffer);
        } else {
//            Logger.d("LogTAG", "request.body() == null");
        }
        //打印url信息
//        Logger.i(request.url() + (request.body() != null ? "&" + parseParams(request.body(), requestBuffer) : ""));
        final Response response = chain.proceed(request);
        //the response data
        ResponseBody body = response.body();

        BufferedSource source = body.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer buffer = source.buffer();
        Charset charset = Charset.defaultCharset();
        MediaType contentType = body.contentType();
        if (contentType != null) {
            charset = contentType.charset(charset);
        }
        String bodyString = buffer.clone().readString(charset);
//        Logger.i(bodyString);
        return response;
    };


    public static final Interceptor sParamInterceptor = chain -> {
        Request original = chain.request();
        //        //添加通用请求参数
        String time = System.currentTimeMillis() + "";
        //        String timeCheckValue = MD5Utils.md5(time + Constants.sTime);
        //        String token = PreferencesUtils.getString(Constants.sUser_token, "");
        //        if (TextUtils.isEmpty(token)) {
        //            token = "4E1B7BA695B57CE2";
        //        }
        //        String tokenCheckValue = MD5Utils.md5(token + Constants.sToken);

        HttpUrl.Builder builder = original.url().newBuilder();
        //        if (PreferencesUtils.getBoolean(Constants.sUser_loginFlag, false)) {
        builder
                .addQueryParameter("token", "5555");
        //                .addQueryParameter(Constants.sRequest_params_token, token)

        //        } else {
        //            builder.addQueryParameter(Constants.sRequest_params_sourceType, Constants.sSourceType_android)
        //                    .addQueryParameter(Constants.sRequest_params_projectId, Constants.sProjectId);
        //        }
        HttpUrl url = builder.build();
        Request request = original.newBuilder()
                .url(url)
                .build();
        return chain.proceed(request);
    };
}
