package com.yanyi.designpattern.chainofresponsibility;

/**
 * handler接口
 * 具体的工作由子类实现该接口完成
 * @author chenqiang
 * @since 2021-01-26 16:56
 */
@HandlerIndex
public interface Handler<T> {

    /**
     * 需子类具体实现的方法
     * @param t
     */
    void before(T t);

    /**
     * 需子类具体实现的方法
     * @param t
     */
    void after(T t);

    /**
     * 默认执行的顺序，可重写改变执行顺序
     * @param t
     */
    default void process(T t) {
        before(t);
        after(t);
    }

}
