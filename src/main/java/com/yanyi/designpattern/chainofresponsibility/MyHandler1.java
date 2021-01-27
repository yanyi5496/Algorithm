package com.yanyi.designpattern.chainofresponsibility;

/**
 * @author chenqiang
 * @since 2021-01-26 17:58
 */
@HandlerIndex(4)
public class MyHandler1 implements Handler<User> {
    @Override
    public void handle(User user) {
        System.out.println("第四个");
        if (user.getAge() > 18) {
            user.setAge(5);
        }
    }
}
