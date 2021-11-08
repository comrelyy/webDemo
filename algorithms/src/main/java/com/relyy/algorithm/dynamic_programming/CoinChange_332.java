package com.relyy.algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange_332 {

    public static void main(String[] args) {
        int[] coins = {5,3};
        int amount = 11;
        int coinQuantity = solution(coins,amount);
        System.out.println(coinQuantity);
        System.out.println(greedSolution(coins, amount, 0));
    }

    //无备忘录/dbTable
    private static int solution(int[] coins, int amount) {
        //amount 变化的状态
        if (amount < 0)
            return -1;
        if (amount == 0) //基本状态
            return 0;
        int quantity = Integer.MAX_VALUE;
        for (int coin : coins) {
            //coin 是选择，导致了amount 的变化 amount
            int subProblem = solution(coins, amount - coin);
            if (subProblem == -1)continue;
            //子问题最优解
            quantity = Math.min(subProblem +1, quantity);
        }
        return quantity == Integer.MAX_VALUE ? -1 : quantity;
    }

    //备忘录模式,自顶向下
    private static int[] mem;
    private static int solution2(int[] coins, int amount) {
        mem = new int[amount+1];
        Arrays.fill(mem,-666);
       return memo(coins, amount);
    }

    private static int memo(int[] coins, int amount) {
        //amount 变化的状态
        if (amount < 0)
            return -1;
        if (amount == 0) //基本状态
            return 0;
        if (mem[amount] != -666)return mem[amount];
        int quantity = Integer.MAX_VALUE;
        for (int coin : coins) {
            //coin 是选择，导致了amount 的变化 amount
            int subProblem = memo(coins, amount - coin);
            if (subProblem == -1)continue;
            //子问题最优解
            quantity = Math.min(subProblem +1, quantity);
        }
        mem[amount] = quantity == Integer.MAX_VALUE ? -1 : quantity;
        return mem[amount];
    }

    //dbtable 自下而上
    private static int solution3(int[] coins, int amount) {
        int[] db = new int[amount+1];
        Arrays.fill(db,amount+1);

        db[0] = 0;
        for (int i = 0; i < db.length; i++){
            for (int coin : coins) {
                if (coin > i) continue;
                db[i] = Math.min(db[i],db[i - coin]+1);
            }
        }
        return db[amount]== amount+1 ? -1 : db[amount];
    }

    /**
     * 贪心算法+回溯
     */
    public static int greedSolution(int[] coins, int amount,int index){
        int minCount = Integer.MAX_VALUE;
        int valueCount = coins.length;

        if (index == valueCount){
            return Math.min(minCount,getMinCoinCountOfValue(amount,coins,0));
        }
        for (int i = index; i < valueCount; i++) {

            //为啥交换顺序？
            int t = coins[index];
            coins[index] = coins[i];
            coins[i] = t;

            // 这个递归的作用
            minCount = Math.min(minCount,greedSolution(coins,amount,index + 1));

            //再次交换
            t = coins[index];
            coins[index] = coins[i];
            coins[i] = t;
        }

        return minCount;
    }

    private static int getMinCoinCountOfValue(int amount, int[] coins, int index) {
        int valueCount = coins.length;
        if (index == valueCount){
            return Integer.MAX_VALUE;
        }

        int minResult = Integer.MAX_VALUE;
        int currentValue = coins[index];
        int maxCount = amount / currentValue;

        for (int i = maxCount; i >= 0; i--) {
            int rest = amount - i * currentValue;

            if (rest == 0) {
                minResult = Math.min(minResult, i);
                break;
            }

            int restCount = getMinCoinCountOfValue(rest, coins, index + 1);

            if (restCount == Integer.MAX_VALUE) {
                if (i == 0){break;}
                continue;
            }

            minResult = Math.min(minResult,i + restCount);
        }
        return minResult;
    }
}
