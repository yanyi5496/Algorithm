package com.yanyi.designpattern.strategy;

/**
 * @author chenqiang
 * @since 2021-01-28 14:36
 */
public class AdvanceMemberStrategy implements Strategy{
    @Override
    public double caclPrice(double price) {
        return price * 0.7;
    }
}
