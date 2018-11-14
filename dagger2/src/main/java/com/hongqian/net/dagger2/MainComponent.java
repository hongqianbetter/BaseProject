package com.hongqian.net.dagger2;

import com.hongqian.net.dagger2.annotation.PerActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Create by HongQian.better on ${DATA}
 **/
@PerActivity
@Component (modules = MainModule.class ,dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity); //这里只能用子类 不能用父类
}
