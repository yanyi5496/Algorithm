package com.yanyi.code.calback;

/**
 * @author chenqiang
 * @date 2020-09-23
 */
public class Test {
    public static void main(String[] args) {
        MasterClass master = new MasterClass(new SalveClass());
        master.askDoSomeThing();
    }
}
