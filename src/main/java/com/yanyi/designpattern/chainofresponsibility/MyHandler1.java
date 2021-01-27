package com.yanyi.designpattern.chainofresponsibility;

/**
 * @author chenqiang
 * @since 2021-01-26 17:58
 */
@HandlerIndex(4)
public class MyHandler1 implements Handler<User> {
    @Override
    public void before(User user) {
        if (user.getAge() > 18) {
            user.setAge(5);
        }
        System.out.println("第四个开始" + user);
    }

    @Override
    public void after(User user) {
        user.setName("新小明");
        System.out.println("第四个结束" + user);
    }
}
