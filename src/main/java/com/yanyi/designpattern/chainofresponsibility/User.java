package com.yanyi.designpattern.chainofresponsibility;

import java.util.Arrays;

/**
 * @author chenqiang
 * @since 2021-01-27 10:50
 */
public class User {
    private int age;
    private String name;
    private String[] friends;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", friends=" + Arrays.toString(friends) +
                '}';
    }
}
