package com.yanyi.code.calback;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * 实现CallBack接口
 *
 * @author chenqiang
 * @date 2020-09-23
 */
public class MasterClass implements CallBack {

    SalveClass salve;

    public MasterClass() {

    }

    public MasterClass(SalveClass salve) {
        this.salve = salve;
    }

    public void askDoSomeThing() {
        //master调用salve中的某个方法
        System.out.println("调用salve做点事");
        StopWatch watch = StopWatch.createStarted();
        salve.toDo(10, this);
        watch.stop();
        System.out.println("watch = " + watch.getTime(TimeUnit.MILLISECONDS));
        watch.reset();
        watch.start();
        salve.async(10, this);
        watch.stop();
        System.out.println("watch = " + watch.getTime(TimeUnit.MILLISECONDS));
    }

    //使用接口可以根据实际情况重写方法
    //实现接口中的回调方法,回调具体做什么
    @Override
    public void execute(int num) {
        System.out.println("被调用方已完成，开始回调，显示结果");
        System.out.println("num = " + num);
    }
}
