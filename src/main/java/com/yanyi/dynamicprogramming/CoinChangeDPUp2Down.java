package com.yanyi.dynamicprogramming;

/**
 * @author chenqiang
 * @description 动态规划自顶向下
 */
public class CoinChangeDPUp2Down {
    //存储中间的计算结果
    private int[] memory;

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
     * 自顶向下
     * @param coins 可选用的硬币面值
     * @param amount 余额
     * @return
     */
    private int findWay(int[] coins, int amount) {
        //
        if (amount < 0) {
            return -1;
        }
        //余额为0 成功
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memory[n]用赋予的值，就不用继续下面的循环
        // 例如在后续使用一个5硬币时，还有6需要凑，在计算时发现前面计算过6块钱时有一个最小需要的硬币数2 就直接使用这个值
        // 已经计算过这种结果，直接返回值
        if (memory[amount - 1] != 0) {
            return memory[amount - 1];
        }

        int min = Integer.MAX_VALUE;


        for (int coin : coins) {
            // 用一下coin这个面值的硬币会怎样？res是这个方法的最优情况
            int res = findWay(coins, amount - coin);
            // res<0 即为 res=-1,此法失败，res>min不是最优情况，舍去
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        // memory[rem - 1]存储着给定金额amount的解
        // 若为Integer.MAX_VALUE则该情况无解
        memory[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return memory[amount-1];
    }
}
