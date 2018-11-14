package com.hongqian.net.mvvm;

import android.app.Application;

import javax.inject.Inject;

/**
 * Create by HongQian.better on ${DATA}
 **/
public class App extends Application {

    private static App mInstance;
    private static AppComponent mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initInjector();

    }

    /**
     * 初始化注射器
     */
    public void initInjector() {
        // 这里不做注入操作，只提供一些全局单例数据
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static App getInstance(){
        return mInstance;
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }
}
