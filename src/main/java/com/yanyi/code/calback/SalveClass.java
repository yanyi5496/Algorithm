package com.yanyi.code.calback;

/**
 * @author chenqiang
 * @date 2020-09-23
 */
public class SalveClass {

    public void toDo(int num, CallBack callBack) {
        //执行相关任务,然后回调

        callBack.execute(num);
    }
}
