package com.hongqian.net.dagger2;

import com.hongqian.net.dagger2.bean.Apple;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Create by HongQian.better on ${DATA}
 **/
@Singleton
@Module
public class AppModule {
    @Singleton
    @Provides
    public Apple providesApple() {
        return new Apple();
    }
}
