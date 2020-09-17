package com.yanyi.code.dynamicprogramming;

/**
 * @author chenqiang
 * @description 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChangeRecursion {

    int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] coins = new int[]{1,3,5};
        int amount = 40;
        long start = System.currentTimeMillis();
        int recursive = new CoinChangeRecursion().recursive(coins, amount);
        System.out.println("recursive = " + recursive);
        long time = System.currentTimeMillis() - start;
        System.out.println("time = " + time);
    }

    /**
     * 递归解决 时间复杂度为O(k*n^k) k为硬币数量
     * @param coins
     * @param amount
     * @return
     */
     int recursive(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        findWayByRecursion(coins,amount,0);

        if (res == Integer.MAX_VALUE) {
            return -1;
        }

        return res;
    }

    /**
     * 递归解决 找出每一条路径所用的数量，存储最短的那一条
     * @param coins
     * @param amount
     * @param count
     */
     void findWayByRecursion(int[] coins, int amount, int count) {
        if (amount < 0) {
            return ;
        }
        if (amount == 0) {
            res = Math.min(res,count);
        }

        for (int coin : coins) {
            findWayByRecursion(coins, amount-coin, count+1);
        }
    }




}
