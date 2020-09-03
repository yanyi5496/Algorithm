package com.yanyi.dynamicprogramming;

/**
 * @author chenqiang
 * @description 动态规划自顶向下
 */
public class CoinChangeDPUp2Down {
    int[] memory;

    public static void main(String[] args) {
        int[] coins = new int[]{1,3,5};
        int amount = 11;
        long start = System.currentTimeMillis();
        int solution = new CoinChangeDPUp2Down().solution(coins, amount);
        System.out.println("solution = " + solution);
        long time = System.currentTimeMillis() - start;
        System.out.println("time = " + time);
    }


    private int solution(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memory = new int[amount];

        return findWay(coins,amount);
    }


    /**
     * memory[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
     * findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
     *
     * @param coins
     * @param amount
     * @return
     */
    private int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memory[amount - 1] != 0) {
            return memory[amount - 1];
        }

        int min = Integer.MAX_VALUE;

        // 记忆化的处理，memory[n]用赋予的值，就不用继续下面的循环
        // 直接的返回memory[n] 的最优值
        for (int coin : coins) {
            int res = findWay(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }

        memory[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return memory[amount-1];
    }
}
