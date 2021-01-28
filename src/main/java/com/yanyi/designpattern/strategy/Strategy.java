package com.yanyi.designpattern.strategy;

/**
 * 会员价格计算策略接口，具体计算策略都需要实现
 * @author chenqiang
 * @since 2021-01-28 14:32
 */
public interface Strategy {
    /**
     * 计算折扣后的价格
     * @param price 原价
     * @return 折扣价
     */
    double caclPrice(double price);
}
