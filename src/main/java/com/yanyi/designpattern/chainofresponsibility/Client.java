package com.yanyi.designpattern.chainofresponsibility;

/**
 * @author chenqiang
 * @since 2021-01-26 17:49
 */
public class Client {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(19);
        new HandlerRegistry<User>()
                .apply(new Handler<User>() {
                    @Override
                    public void handle(User user) {
                        user.setAge(16);
                        System.out.println("第一个");
                    }
                })
                .apply(new MyHandler1())
                .apply(new Handler<User>() {
                    @Override
                    public void handle(User user) {
                        System.out.println("第二个");
                    }
                })
                .apply(new MyHandler2())
                .invoke(user);
    }
}
