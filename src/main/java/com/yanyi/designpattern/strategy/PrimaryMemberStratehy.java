package com.yanyi.designpattern.strategy;

/**
 * @author chenqiang
 * @since 2021-01-28 14:34
 */
public class PrimaryMemberStratehy implements Strategy{
    @Override
    public double caclPrice(double price) {
        return price * 0.9;
    }
}
