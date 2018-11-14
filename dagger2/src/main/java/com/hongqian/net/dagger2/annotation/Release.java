package com.hongqian.net.dagger2.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Create by HongQian.better on ${DATA}
 **/
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Release {
}
