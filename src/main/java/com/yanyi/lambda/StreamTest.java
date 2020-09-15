package com.yanyi.lambda;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author chenqiang
 * @date 2020-09-14
 */
public class StreamTest {


    @Test
    public void mapToInt() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //
        int sum = list.stream().mapToInt(value -> value + 1).sum();
        int sum1 = list.stream().filter(v -> v > 2).mapToInt(v -> v).sum();
        System.out.println("sum1 = " + sum1);
        System.out.println("sum = " + sum);

    }

}
