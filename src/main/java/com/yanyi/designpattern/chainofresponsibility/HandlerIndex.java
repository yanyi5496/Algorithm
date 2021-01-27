package com.yanyi.designpattern.chainofresponsibility;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 执行的顺序，默认以apply的顺序
 * @author Chen
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HandlerIndex {
    int value() default 5;
}
