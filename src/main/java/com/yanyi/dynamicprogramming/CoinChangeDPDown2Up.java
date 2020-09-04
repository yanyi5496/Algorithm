package com.yanyi.dynamicprogramming;

import java.util.Arrays;

/**
 * @author chenqiang
 * @description 兑换硬币 动态规划 自底向上 带备忘录
 */
public class CoinChangeDPDown2Up {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 3, 5};
        int amount = 15000897;
        long start = System.currentTimeMillis();
        int change = new CoinChangeDPDown2Up().coinChange(coins, amount);
        System.out.println("change = " + change);
        long end = System.currentTimeMillis() - start;
        System.out.println("end = " + end);
    }

    /**
     *
     * @param coins
     * @param amount 余额
     * @return
     */
    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //将初值都设置为amount+1
        Arrays.fill(dp, amount + 1);
        //存储要index的目标金额时需要最小的硬币数
        dp[0] = 0;
        //i控制目标金额，从底一直升到输入值  循环在遍历所有状态的所有取值
        for (int i = 0; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            //使用不同的硬币值放入计算 循环在求所有选择的最小值
            for (int coin : coins) {
                //需要金额减币值小于0 不合条件 跳出
                if (i - coin < 0) {
                    continue;
                }
                //简单理解为 当前需要的最小币数为扣除现币金额所需要的币数加现一个币的数量
                // F(2)=min(F(2-1),F(2-2),F(2-5))+1=1F(2)=min(F(2−1),F(2−2),F(2−5))+1=1
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
