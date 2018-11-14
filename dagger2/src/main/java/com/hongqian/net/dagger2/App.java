package com.hongqian.net.dagger2;

import android.app.Application;

/**
 * Create by HongQian.better on ${DATA}
 **/
public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
    }

    public static AppComponent getAppComInstance(){
        return  appComponent;
    }
}
