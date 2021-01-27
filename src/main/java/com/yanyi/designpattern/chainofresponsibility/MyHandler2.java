package com.yanyi.designpattern.chainofresponsibility;

/**
 * @author chenqiang
 * @since 2021-01-26 18:20
 */
@HandlerIndex(3)
public class MyHandler2 implements Handler<User>{
    @Override
    public void handle(User user) {
        System.out.println("第三个");
        user.setName("abc");
    }
}
