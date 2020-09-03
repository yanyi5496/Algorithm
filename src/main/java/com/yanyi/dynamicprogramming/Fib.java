package com.yanyi.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqiang
 * @description 斐波那契数列 等于前两个数之和 0 1 1 2 3 5 8 13 21...
 * @url https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/dong-tai-gui-hua-xiang-jie-jin-jie
 */
public class Fib {

    public static void main(String[] args) {
        int N = 45;

        long start = System.currentTimeMillis();
        long fib = fib(N);
        System.out.println("fib = " + fib);
        long end = System.currentTimeMillis() - start;
        System.out.println("end = " + end);

        long x = System.currentTimeMillis();
        long dp = dp(N);
        System.out.println("dp = " + dp);
        long y = System.currentTimeMillis() - x;
        System.out.println("y = " + y);

        long millis = System.currentTimeMillis();
        int i = optmizeDp(N);
        System.out.println("i = " + i);
        long value = System.currentTimeMillis() - millis;
        System.out.println("value = " + value);


        long time1 = System.currentTimeMillis();
        int recursion = basicRecursion(N);
        System.out.println("recursion = " + recursion);
        long time2 = System.currentTimeMillis() - time1;
        System.out.println("time = " + time2);


    }

    /**
     * 通过递归获取 时间复杂度O(2^n)，
     *
     * @param n 索引值
     * @return 该索引位置的值
     */
    private static int basicRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return basicRecursion(n - 1) + basicRecursion(n - 2);
    }


    private static long fib(int n) {
        if (n == 0) {
            return 0;
        }
        Map<Integer, Long> memory = new HashMap<>();
        return dpRecursion(memory, n);
    }

    /**
     * 带备忘录的递归解法 自顶向下求解
     * 时间复杂度为O(n)，将计算过的值做一个备份，需要时直接取值，不再重新计算
     *
     * @param memory 存储已计算过的数据
     * @param n
     * @return
     */
    private static long dpRecursion(Map<Integer, Long> memory, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (memory.get(n) != null) {
            return memory.get(n);
        }

        memory.put(n, dpRecursion(memory, n - 1) + dpRecursion(memory, n - 2));
        return memory.get(n);
    }

    /**
     * dp的迭代解法 自底向上求解,依次计算出每一项的值
     *
     * @param n
     * @return
     */
    private static long dp(int n) {
        Map<Integer, Integer> memory = new HashMap<>();
        memory.put(0, 0);
        memory.put(1, 1);
        memory.put(2, 1);
        for (int i = 3; i <= n; i++) {
            memory.put(i, memory.get(i - 1) + memory.get(i - 2));
        }
        return memory.get(n);
    }

    /**
     * dp的迭代解法 自底向上求解,依次计算出每一项的值
     * 结果态只和上两个状态有关，只存储上两个状态即可 状态压缩
     * 在上一个解法的基础上，将空间复杂度降到了O(1)
     *
     * @param n
     * @return
     */
    private static int optmizeDp(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre = 1;
        int curr = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = curr + pre;
            pre = curr;
            curr = sum;
        }
        return sum;
    }

}
