package com.yanyi.designpattern.chainofresponsibility;

/**
 * @author chenqiang
 * @since 2021-01-26 18:20
 */
@HandlerIndex(3)
public class MyHandler2 implements Handler<User>{
    @Override
    public void before(User user) {
        user.setName("abc");
        System.out.println("第三个开始" + user);
    }

    @Override
    public void after(User user) {
        user.setFriends(new String[]{"小明"});
        System.out.println("第三个结束" + user);
    }

    @Override
    public void process(User user) {
        after(user);
        before(user);
    }
}
