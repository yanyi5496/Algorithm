package com.yanyi.code.proxy.staticproxy;

/**
 * @author chenqiang
 * @date 2020-09-25
 * @see <a href="https://zhuanlan.zhihu.com/p/62660956">参考</a>
 */
public class Test {
    public static void main(String[] args) {
        //直接调用代理对象 传入实际的实现对象
        CalculatorProxy proxy = new CalculatorProxy(new CalculatorImpl());
        proxy.add(10, 11);
        proxy.substract(15, 10);
    }
}
