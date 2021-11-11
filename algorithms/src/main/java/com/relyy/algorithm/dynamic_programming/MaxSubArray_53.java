package com.relyy.algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * @Description
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * @Created by cairuirui
 * @Date 2021/11/9
 */
public class MaxSubArray_53 {

	public static void main(String[] args) {
		int[] nums = {8,-19,5,-4,20};
		int result = dpSolution(nums);
		System.out.println(result);
	}

	/**
	 * 滑动窗口,穷举了  时间复杂度太高
	 * @param nums
	 * @return
	 */
	private static int slidWindowSolution(int[] nums) {
		int length = nums.length;
		if (length == 1)return nums[0];
		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j <= length-i; j++) {
				int tempResut = 0;
				int step = 0;
				while (step < i){
					tempResut += nums[j+step];
					step++;
				}
				result = Math.max(result,tempResut);
			}
		}
		return result;
	}

	/**
	 * 采用动态规划 证明思路是错的
	 * db[i] 标识 当前下标为i时 数组的最大值
	 *  S[i] > 0 db[i] = db[i-1] + S[i]
	 *  S[i] <= 0 Math.max{db[i],S[i]}
	 * * @param nums
	 * @return
	 */
	public static int dpSolution(int[] nums){

		int length = nums.length;
		if (length == 1)return nums[0];
		int result = Integer.MIN_VALUE;

		int[] dp = new int[length+1];
		Arrays.fill(dp,Integer.MIN_VALUE);
		int index = 0;
		for (int i = 1; i <= length; i++) {
			if (result == Integer.MIN_VALUE){
				result = Math.max(result,nums[i-1]);
			}
			if (nums[i-1] > 0){
				if (dp[i - 1] == Integer.MIN_VALUE){
					dp[i] = nums[i-1];
					index = i -1;
					result = Math.max(dp[i],result);
				}else {
					if (dp[i - 1] >= 0) {
						//dp[i] = dp[i - 1] + nums[i - 1];
						int tmp = dp[i - 1];
						int tmpIndex = index;
						while (tmpIndex < i - 1){
							tmpIndex++;
							tmp += nums[tmpIndex];
						}
						if (tmp > dp[i - 1] && tmp > nums[i - 1]){
							dp[i] = tmp;
							index = i -1;
						}else {
							dp[i] = Math.max(nums[i - 1],dp[i - 1]);
							if (nums[i - 1] > dp[i-1]){
								index = i - 1;
							}
						}

					}else {
						dp[i] = Math.max(nums[i - 1],dp[i - 1]);
						if (nums[i - 1] > dp[i-1]){
							index = i - 1;
						}
					}
					result = dp[i];
				}
			}else {
				dp[i] = Math.max(dp[i - 1],nums[i-1]);
				if (nums[i - 1] > dp[i-1]){
					index = i - 1;
				}
				result = dp[i];
			}
		}
		return result;
	}

	public static int dp2Solution(int[] nums) {

		int length = nums.length;
		if (length == 1) return nums[0];
		int result = nums[0];
		int remian = 0;
		for (int num : nums) {
			//之前的结果是 是可以对当前元素是增强还是削弱
			remian = Math.max(remian + num,num);
			// 增强后的结果是否大于原结果
			result = Math.max(remian,result);
		}
		return result;
	}
}
