package com.yanyi.code.calback;

/**
 * @author chenqiang
 * @date 2020-09-23
 */
public class Test {
    public static void main(String[] args) {
        MasterClass master = new MasterClass();
        SalveClass salve = new SalveClass();
        master.salve = salve;
        master.askDoSomeThing();
    }
}
