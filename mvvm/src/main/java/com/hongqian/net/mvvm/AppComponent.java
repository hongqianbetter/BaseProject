package com.hongqian.net.mvvm;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Create by HongQian.better on ${DATA}
 **/
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context getAppContext();

    Retrofit getRetrofit();

    RxBus getRxBus();

    RetrofitService createService();

}
