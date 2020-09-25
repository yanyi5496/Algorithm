package com.yanyi.code.proxy.staticproxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author chenqiang
 * @date 2020-09-25
 */
public class ProxyTest {
    public static void main(String[] args) {
        /*Calculator接口的Class对象
          得到Class对象的三种方式：1.Class.forName(xxx)
                               2.xxx.class
                               3.xxx.getClass()
          注意，这并不是我们new了一个Class对象，而是让虚拟机加载并创建Class对象
        */
        Class<Calculator> calculatorClass = Calculator.class;
        Constructor<?>[] constructors = calculatorClass.getConstructors();
        //接口中没有构造器  不能直接new对象出来
        System.out.println("constructors = " + Arrays.toString(constructors));
        Method[] methods = calculatorClass.getMethods();
        //接口中包含定义的抽象方法
        System.out.println("methods = " + Arrays.toString(methods));

        System.out.println();

        Class<CalculatorImpl> calculatorImplClass = CalculatorImpl.class;
        //包含一个默认的无参构造方法
        Constructor<?>[] implClassConstructors = calculatorImplClass.getConstructors();
        System.out.println("implClassConstructors = " + Arrays.toString(implClassConstructors));
        //从接口实现的成员方法和从超类Object继承的方法
        Method[] implClassMethods = calculatorImplClass.getMethods();
        System.out.println("implClassMethods = " + Arrays.toString(implClassMethods));
    }
}
