package com.yanyi.designpattern.treeofresponsibility;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @author chenqiang
 * @since 2021-01-27 14:22
 */
public abstract class AbstractStrategyRouter<T, R> {
    /**
     * 策略映射器，根据指定的入参路由到对应的策略处理者
     * @param <T> 策略的入参类型
     * @param <R> 策略的返回值类型
     */
    public interface StrategyMapper<T, R> {
        /**
         * 通过入参获取对应的入参处理者
         * @param t
         * @return
         */
        StrategyHandler<T, R> get(T t);
    }

    private StrategyMapper<T, R> strategyMapper;

    /**
     * 抽象方法，子类实现分发逻辑
     * @return
     */
    protected abstract StrategyMapper<T, R> registerStragtegyMapper();

    /**
     * 类初始化时注册分发策略Mapper
     */
    @PostConstruct
    private void abstractInit() {
        StrategyMapper<T, R> strategyMapper = registerStragtegyMapper();
        Objects.requireNonNull(strategyMapper, "策略不能为空");
    }

    @SuppressWarnings("unchecked")
    private final StrategyHandler<T, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    /**
     * 执行策略，会自动根据策略分发至下游的handler处理
     * @param t 入参
     * @return 下游给出的返回值
     */
    public R applyStrategy(T t) {
        final StrategyHandler<T, R> handler = strategyMapper.get(t);
        if (handler != null) {
            return handler.apply(t);
        }
        return defaultStrategyHandler.apply(t);
    }
}
