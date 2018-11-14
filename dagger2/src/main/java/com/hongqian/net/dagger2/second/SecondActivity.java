package com.hongqian.net.dagger2.second;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hongqian.net.dagger2.App;
import com.hongqian.net.dagger2.R;
import com.hongqian.net.dagger2.bean.Apple;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    @Inject
    Apple apple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        App.getAppComInstance().addStub(new SecondModule()).inject(this);

        Log.e(this.getClass().getSimpleName(),apple.toString()+"-------");
    }
}
