package com.hongqian.net.dagger2;

import com.hongqian.net.dagger2.bean.Apple;
import com.hongqian.net.dagger2.second.SecondComponent;
import com.hongqian.net.dagger2.second.SecondModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Create by HongQian.better on ${DATA}
 **/
//component的inject方法接受父类参数,而调入时传入的是子类型参数对象则无法注入
//module的provide 方法 使用了scope ,那么component就必须使用同一个注解
//module 的provide方法没有使用scope ,那么component和module是否加scope 都无关紧要 ,可以通过编译

//没有scope的component不能依赖其他scope的component
//singleton的生命周期依附于component,
//component的dependence与component自身的scope不能相同
//singleton的组件不能dependence其他组件 ,而 其他的component可以依赖 singleton的组件
//一个component不能同时有多个scope (subcomponent除外)
@Singleton
@Component (modules = AppModule.class)
public interface AppComponent {
    Apple getAppleIns();  //component依赖component的方式
    SecondComponent addStub(SecondModule secondModule); //addStub stubComponent方式 //好处可以对SecondComponent暴露 没有 显示提供的provides
}
