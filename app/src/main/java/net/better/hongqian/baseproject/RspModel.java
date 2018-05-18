package net.better.hongqian.baseproject;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RspModel<T> {
    //错误状态码
    public static final int SUCCEED = 1;

    public static final int ERROR_UNKNOWN = 0;

    public static final int ERROR_NOT_FOUND_USER = 4041;
    public static final int ERROR_NOT_FOUND_GROUP = 4042;
    public static final int ERROR_NOT_FOUND_GROUP_MEMBER = 4043;

    public static final int ERROR_CREATE_USER = 3001;
    public static final int ERROR_CREATE_GROUP = 3002;
    public static final int ERROR_CREATE_MESSAGE = 3003;

    public static final int ERROR_PARAMETERS = 4001;
    public static final int ERROR_PARAMETERS_EXIST_ACCOUNT = 4002;
    public static final int ERROR_PARAMETERS_EXIST_NAME = 4003;

    public static final int ERROR_SERVICE = 5001;

    public static final int ERROR_ACCOUNT_TOKEN = 2001;
    public static final int ERROR_ACCOUNT_LOGIN = 2002;
    public static final int ERROR_ACCOUNT_REGISTER = 2003;

    public static final int ERROR_ACCOUNT_NO_PERMISSION = 2010;

    @SerializedName("code") //这里对应json中的 code字段 这个字段可以是其他名字 主要是让json中的字段解析转化到code里面赋值 起一个连接的作用
    private int code;
    @SerializedName("message")
    private String message;
    @SerializedName("time")
    private Date time;
    @SerializedName("data")
    private T result;

    public boolean success() {
        return code == SUCCEED;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}