package com.hongqian.net.mvvm;





/**
 * Created by 王少岩 on 2016/9/14.
 */
public class HttpConsts {

    public static final String SERVER = "http://api.jyj.b2bex.com/";//正式网地址
    public static final String SERVER_TEXT = "http://api.jyj.b2bex.com/";//测试网地址

    /**
     * 设置服务地址
     *
     * @param server
     */
    public static void setServer(String server) {
        if (BuildConfig.DEBUG) {
            PreferencesUtils.saveString(Constants.sServerTest, server);
        } else {
            PreferencesUtils.saveString(Constants.sServer, server);
        }
    }

    public static String getServer() {
        if (BuildConfig.DEBUG) {
            return PreferencesUtils.getString(Constants.sServerTest, SERVER_TEXT);
        } else {
            return PreferencesUtils.getString(Constants.sServer, SERVER);
        }
    }
}
