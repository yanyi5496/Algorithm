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
                .apply(new MyHandler1())
                .apply(new MyHandler2())
                .invoke(user);
        System.out.println("user = " + user);
    }
}
