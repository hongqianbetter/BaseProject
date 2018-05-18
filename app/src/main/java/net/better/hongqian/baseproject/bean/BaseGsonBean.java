package net.better.hongqian.baseproject.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shijianan on 2017/4/19.
 * 封装的api请求实体类对象因为api返回的json基本格式为{errno:0,msg:ok,data:}
 * 所以可以把data封装成一个泛型对象T
 */

public class BaseGsonBean<T> {

    @SerializedName("errno")
    private int errno;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private T data;

    public BaseGsonBean(int errno, String msg, T data) {
        this.errno = errno;
        this.msg = msg;
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseGsonBean{" +
                "errno=" + errno +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}