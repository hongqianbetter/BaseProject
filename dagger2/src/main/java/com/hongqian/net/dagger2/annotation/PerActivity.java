package com.hongqian.net.dagger2.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Create by HongQian.better on ${DATA}
 **/
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {
}
