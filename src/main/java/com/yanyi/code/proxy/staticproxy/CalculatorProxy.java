package com.yanyi.code.proxy.staticproxy;

/**
 * 代理对象实现类
 * @author chenqiang
 * @date 2020-09-25
 */
public class CalculatorProxy implements Calculator{

    //代理对象内部维护一个目标对象引用
    Calculator target;

    public CalculatorProxy() {
    }

    public CalculatorProxy(Calculator target) {
        this.target = target;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("add---");
        int add = target.add(a, b);
        System.out.println("+++and");
        return add;
    }

    @Override
    public int substract(int a, int b) {
        System.out.println("substract---");
        int substract = target.substract(a, b);
        System.out.println("+++");
        return 0;
    }
}
