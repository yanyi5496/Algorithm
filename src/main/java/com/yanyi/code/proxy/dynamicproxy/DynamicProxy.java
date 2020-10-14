package com.yanyi.code.proxy.dynamicproxy;

import com.yanyi.code.proxy.staticproxy.Calculator;
import com.yanyi.code.proxy.staticproxy.CalculatorImpl;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author chenqiang
 * @date 2020-09-25
 */
public class DynamicProxy {
    public static void main(String[] args) throws Throwable {
        Calculator proxy = (Calculator) getProxy(new CalculatorImpl());
        proxy.add(10, 11);
        proxy.substract(15, 2);
    }


    //得到代理类
    public static Object getProxy(final Object target) throws Exception {
        Class<?> proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        //通过参数列表得到有参构造器 public com.sun.proxy.$Proxy0(java.lang.reflect.InvocationHandler)
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        //constructor.newInstance()需要传入一个InvocationHandler对象，这里采用匿名对象的方式，invoke()方法不做具体实现，直接返回null
        return constructor.newInstance((InvocationHandler) (proxy, method, args1) -> {
            System.out.println("starting");
            Object result = method.invoke(target, args1);
            System.out.println("result = " + result);
            System.out.println("ending");
            return result;
        });

    }


    /**
     * 由于通过代理生成的Class对象中只有有参构造方法，而newInstance()调用的是无参构造方法，所以失败
     */
    @Test
    public void test1() {
        Class<?> proxyClass = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
        try {
            proxyClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
