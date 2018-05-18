package net.better.hongqian.baseproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.better.hongqian.baseproject.bean.BaseGsonBean;
import net.better.hongqian.baseproject.bean.QuesEntity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Observable<BaseGsonBean<QuesEntity>> observable = Network.getRetrofit().create(RemoteService.class).getType(1);
//
//        observable
//                .subscribeOn(Schedulers.io()) //异步线程订阅
//                .observeOn(AndroidSchedulers.mainThread()) //通知到主线程
//                .subscribe(new Consumer<BaseGsonBean<QuesEntity>>() {
//            @Override
//            public void accept(BaseGsonBean<QuesEntity> quesEntityBaseGsonBean) throws Exception {
//                Log.e("newwork",quesEntityBaseGsonBean.toString()+"onnext");
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                Log.e("newwork",throwable.getLocalizedMessage()+"onError");
//            }
//        }, new Action() {
//            @Override
//            public void run() throws Exception {
//                Log.e("newwork","onCommplement");
//            }
//        });

//        RetrofitObserver<BaseGsonBean<String>> retrofitObserver = new RetrofitObserver<BaseGsonBean<String>>() {
//
//
//            @Override
//            public void onSucess(BaseGsonBean<String> quesEntityBaseGsonBean) {
//                Log.e("sss", quesEntityBaseGsonBean.toString());
//
//            }
//
//            @Override
//            public void onFailed(Throwable e) {
//                Log.e("sss", e.getMessage());
//            }
//        };
//
//        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(retrofitObserver);
//        retrofitObserver.disposable.dispose();


//        .flatMap(new Function<BaseGsonBean<QuesEntity>, ObservableSource<BaseGsonBean<String>>>() {
//
//            @Override
//            public ObservableSource<BaseGsonBean<String>> apply(BaseGsonBean<QuesEntity> quesEntityBaseGsonBean) throws Exception {
//                Log.e("thread :", Thread.currentThread().getName());
//                return Network.getRetrofit().create(RemoteService.class).getCourse();
//            }
//        })

        observable
                .subscribeOn(Schedulers.io()) //异步线程订阅
                .observeOn(AndroidSchedulers.mainThread()) //通知到主线程

                .compose(new ObservableTransformer<BaseGsonBean<QuesEntity>, BaseGsonBean<String>>() {
                    @Override
                    public ObservableSource<BaseGsonBean<String>> apply(Observable<BaseGsonBean<QuesEntity>> upstream) {
                         return Network.getRetrofit().create(RemoteService.class).getCourse();
                    }
                })
                .subscribeOn(Schedulers.io()) //异步线程订阅
                .observeOn(AndroidSchedulers.mainThread()) //通知到
        .subscribe(new RetrofitObserver<BaseGsonBean<String>>() {
            @Override
            public void onSucess(BaseGsonBean<String> stringBaseGsonBean) {

            }

            @Override
            public void onFailed(Throwable e) {
                Log.e("thread ----:", Thread.currentThread().getName());
                Log.e("error ----:", e.getMessage());
    }});
}
    }
