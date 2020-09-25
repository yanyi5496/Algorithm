package com.yanyi.code.proxy.dynamicproxy;

import com.yanyi.code.proxy.staticproxy.Calculator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 该类测试使用Proxy.getProxyClass之后得到Class对象中的信息
 * @author chenqiang
 * @date 2020-09-25
 */
public class TestProxy {
    public static void main(String[] args) {
        /*
         * 参数1：Calculator的类加载器（当初把Calculator加载进内存的类加载器）
         * 参数2：代理对象需要和目标对象实现相同接口Calculator
         * */
        //不再需要去写接口的代理实现类，直接通过接口获得代理对象
        Class<?> proxyClass = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
        System.out.println("proxyClass = " + proxyClass.getName());
        Constructor<?>[] constructors = proxyClass.getConstructors();
        //传入类加载器和接口Class对象之后，生成了构造器方法
        System.out.println("constructors = " + Arrays.toString(constructors));
        Method[] methods = proxyClass.getMethods();
        //包含了接口方法和 Object类的方法
        System.out.println("methods = " + Arrays.toString(methods));
    }
}
