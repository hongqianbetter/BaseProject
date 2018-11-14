package com.hongqian.net.dagger2;

import android.util.Log;

import com.hongqian.net.dagger2.annotation.Release;
import com.hongqian.net.dagger2.annotation.dev;
import com.hongqian.net.dagger2.bean.Dog;
import com.hongqian.net.dagger2.bean.Person;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Create by HongQian.better on ${DATA}
 **/
@Module
public class MainModule {
    MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity=activity;
    }
//    @Named("release")
    @Provides
    public Person providePerson(){
        return new Person();
    }
//    @Named("dev")
//    @Provides
//    public Person provideOtherPerson(){
//        return new Person();
//    }

    @Provides
    @Release
    public Dog provideDog(){
        Log.e(this.getClass().getSimpleName(),"provide Dog execute");
        return new Dog();
    }
    @Provides
    @dev
    public Dog provideOtherDog(){
        Log.e(this.getClass().getSimpleName(),"provide another Dog execute");
        return new Dog();
    }

}
