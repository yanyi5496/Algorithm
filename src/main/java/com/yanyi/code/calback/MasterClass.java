package com.yanyi.code.calback;

/**
 * 实现CallBack接口
 * @author chenqiang
 * @date 2020-09-23
 *
 */
public class MasterClass implements CallBack {

    SalveClass salve;

    public void askDoSomeThing() {
        //master调用salve中的某个方法
        salve.toDo(10, this);
    }

    //实现接口中的回调方法,回调具体做什么
    @Override
    public void execute(int num) {
        System.out.println("num = " + num);
    }
}
