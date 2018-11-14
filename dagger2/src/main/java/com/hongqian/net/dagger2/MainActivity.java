package com.hongqian.net.dagger2;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hongqian.net.dagger2.annotation.Release;
import com.hongqian.net.dagger2.annotation.dev;
import com.hongqian.net.dagger2.bean.Apple;
import com.hongqian.net.dagger2.bean.Dog;
import com.hongqian.net.dagger2.bean.Person;
import com.hongqian.net.dagger2.second.SecondActivity;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

//    @Named ("release") // @Named是@Qualify的一种,用于区分不同实例  不同的是@qualify修饰的是
    @Inject
    Person person1;
//    @Named("dev")
    @Inject
    Person person2;

    @Release //自定义qualify
    @Inject
    Dog dog;
    @dev
    @Inject
    Dog dog1;

    @Inject
    Apple apple1;
    @Inject
    Apple apple2;
    private TextView tv_next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_next = findViewById(R.id.tv_next);

        DaggerMainComponent.builder().appComponent(App.getAppComInstance()).mainModule(new MainModule(this)).build().inject(this);
        Log.e(this.getClass().getSimpleName(),person1.toString()+"-------"+person2.toString());


        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });



    }
}
