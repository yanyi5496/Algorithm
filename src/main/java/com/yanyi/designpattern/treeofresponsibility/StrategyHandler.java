package com.yanyi.designpattern.treeofresponsibility;

/**
 * @author chenqiang
 * @since 2021-01-27 14:30
 */
public interface StrategyHandler<T, R> {

    @SuppressWarnings("rowtypes")
    StrategyHandler DEFAULT = t -> null;

    /**
     * apply strategy
     * @param t 策略
     * @return 具体处理应用
     */
    R apply(T t);
}
