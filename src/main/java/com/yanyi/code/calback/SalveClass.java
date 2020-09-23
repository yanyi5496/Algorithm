package com.yanyi.code.calback;

/**
 * @author chenqiang
 * @date 2020-09-23
 */
public class SalveClass {

    public void toDo(int num, CallBack callBack) {
        //执行相关任务
        System.out.println("被调用方做事，将数字加5");
        num += 5;
        //然后回调
        callBack.execute(num);
    }

    public void async(int num, CallBack callBack) {
        Runnable runnable = () -> {
            try {
                Thread.sleep(3000);
                int x = num + 111;
                callBack.execute(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        runnable.run();
    }
}
