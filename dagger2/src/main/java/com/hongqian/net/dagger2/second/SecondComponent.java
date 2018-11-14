package com.hongqian.net.dagger2.second;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Create by HongQian.better on ${DATA}
 **/

//(1)@Subcomponent不能再使用dependencies依赖其他@Component。

@Subcomponent (modules = SecondModule.class)
public interface SecondComponent {
    void  inject(SecondActivity activity);
}
