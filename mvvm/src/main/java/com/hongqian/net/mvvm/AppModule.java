package com.hongqian.net.mvvm;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.hongqian.net.mvvm.RetrofitService.sLoggingInterceptor;
import static com.hongqian.net.mvvm.RetrofitService.sParamInterceptor;

/**
 * Create by HongQian.better on ${DATA}
 **/
@Singleton
@Module
public class AppModule {
    App mApp;

    public AppModule(App app) {
        this.mApp = app;

    }

    @Singleton
    @Provides
    public Context provideContext(){
        return mApp.getApplicationContext();
    }

    @Singleton
    @Provides
    public RxBus provideRxBus(){
        return new RxBus();
    }


    @Singleton
    @Provides
    public Retrofit provideRetrofit(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(sParamInterceptor)
                .addInterceptor(sLoggingInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(HttpConsts.getServer())
                .build();
        return retrofit;

    }
}
