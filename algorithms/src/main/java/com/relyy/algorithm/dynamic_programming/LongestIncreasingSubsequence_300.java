package com.relyy.algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。(LIS)
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LongestIncreasingSubsequence_300 {

    public static int[] db;
    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};


        System.out.println(getLis(nums));
    }

    public static int getLis(int[] nums){
        db = new int[nums.length];
        Arrays.fill(db,0);
        int longest = 1;
        for (int i = 0; i < nums.length; i++) {
            db[i] = solution(nums,i);
            longest = Math.max(db[i],longest);
        }
        return longest;
    }

    private static int solution(int[] nums,int curIndex) {
        if (curIndex == 0) return 1;
        if (db[curIndex] != 0) return db[curIndex];
        int longest = 1;
        int maxNum = nums[curIndex];

        for (int i = curIndex - 1 ; i >= 0; i--) {
            if (maxNum > nums[i]){
                int tmp = solution(nums, i);
                longest = Math.max(longest,tmp + 1);
            }
        }
//        System.out.println(" ================= ");
//        System.out.println("curIndex: "+ curIndex);
//        System.out.println("maxNum: "+ maxNum);
//        System.out.println("longest: "+ longest);
//        System.out.println(" ================= ");
        return longest;
    }
}
