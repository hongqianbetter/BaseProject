package net.better.hongqian.baseproject;


import net.better.hongqian.baseproject.logger.LogUtil;
import net.better.hongqian.common.Application;

/**
 * Created by HongQian.Wang on 2018/5/16.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Factory.setup();
        LogUtil.init(BuildConfig.DEBUG);
    }
}
