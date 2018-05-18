package net.better.hongqian.baseproject;

/**
 * Created by HongQian.Wang on 2018/5/17.
 */
public class HttpThrowable extends Throwable {
    private int Code;
    public HttpThrowable(String message ,int code) {
        super(message);
        this.Code=code;
    }

//    @Override
//    public String getLocalizedMessage() {
//        return Factory.decodeRspCode();
//    }
}
