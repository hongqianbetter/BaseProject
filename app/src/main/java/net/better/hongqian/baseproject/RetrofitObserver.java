package net.better.hongqian.baseproject;

import net.better.hongqian.baseproject.bean.BaseGsonBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by HongQian.Wang on 2018/5/17.
 */
public abstract class RetrofitObserver<T> implements Observer<T> {
    public Disposable disposable;

    @Override
    public void onSubscribe(Disposable d) {
        this.disposable = d;
    }

    @Override
    public void onNext(T t) {
        if (t instanceof BaseGsonBean)
        {
            BaseGsonBean bean = (BaseGsonBean) t;
            int code = bean.getErrno();
            if(code==200) {
                onSucess(t);
            }else {
                onFailed(new Throwable(bean.getMsg()));
            }

        }




    }

    @Override
    public void onError(Throwable e) {

        onFailed(e);
    }

    @Override
    public void onComplete() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    public abstract void onSucess(T t);

    public abstract void onFailed(Throwable e);
}
