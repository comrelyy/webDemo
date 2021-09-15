package com.relyy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class ClimbStairs {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int result = sulotion(45,list);
        System.out.println(result);
    }

    public static int sulotion(int n, List<Integer> list){
        if (n < 3) {
            list.add(n,n);
            return n;
        }
        if (list.size() < n){
            list.add(n,sulotion(n-1,list)+sulotion(n-2,list));
        }
        return   list.get(n);
    }
}
