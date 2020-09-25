package com.yanyi.code.proxy.staticproxy;

/**
 * 目标对象实现类
 * @author chenqiang
 * @date 2020-09-25
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int substract(int a, int b) {
        return a - b;
    }
}
