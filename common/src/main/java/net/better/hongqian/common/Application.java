package net.better.hongqian.common;

import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.StringRes;
import android.support.multidex.MultiDexApplication;
import android.widget.Toast;

import java.io.File;

/**
 * 在这里提供一些公共的资源
 * Created by HongQian.Wang on 2018/5/16.
 */
public class Application extends MultiDexApplication {

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public static Application getInstance() {
        return instance;
    }

    public static File getCacheDirFile(){
        return instance.getCacheDir();
    }

    /**
     * 获取重新生成头像的路径
     *
     * @return
     */
    public static File getPortraitTemFile(){
        File dir = new File(getCacheDirFile(), "portrait");
        dir.mkdirs(); //创建所对应的文件夹

        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                file.delete();
            }
        }

        File path = new File(dir, SystemClock.uptimeMillis() + ".jpg");
        return path;
    }
    /**
     * 异步线程也可弹土司
     *
     * @param msg
     */
    public static void showToast(String msg) {
        Looper.prepare();
        Toast.makeText(instance, msg, Toast.LENGTH_SHORT).show();
        Looper.loop();
    }

    public static void showToast(@StringRes int resId) {
        showToast(instance.getResources().getString(resId));

    }
}
