package com.yanyi.oom;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqiang
 * @since 2021-01-26 14:20
 */
public class OOMTest {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Tom> map = new HashMap<>();
        int counter = 1;
        while (true) {
            Thread.sleep(10);
            Tom tom = new Tom();
            String[] friends = new String[counter];
            for (int i = 0; i < friends.length; i++) {
                friends[i] = "friends" + i;
            }
            tom.setAge(counter);
            tom.setName("tom" + counter);
            tom.setFriends(friends);
            map.put(tom.getName(), tom);
            if (counter % 100 == 0) {
                System.out.println("put" + counter);
            }
            counter++;
        }
    }

}
