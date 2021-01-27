package com.yanyi.designpattern.chainofresponsibility;

/**
 * handler接口
 * @author chenqiang
 * @since 2021-01-26 16:56
 */
@HandlerIndex
public interface Handler<T> {

    /**
     * 需子类具体实现的方法
     * @param t
     */
    default void handle(T t) {

    }

}
