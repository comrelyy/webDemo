package com.relyy.array;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 */
public class SearchRange {

	public static void main(String[] args) {
		int[] nums = {9};//{}//[5,7,7,8,8,10]
		int target = 9;
		int[] result = solution1(nums, target);
		System.out.println(result[0]+":"+result[1]);
	}

	public static int[] solution1(int[] nums, int target) {
		int length = nums.length;
		int head = 0;
		int tail = length - 1;
		if(tail < 0 || nums[head] > target || nums[tail] < target) return new int[]{-1,-1};
		while (head <= tail && nums[head] < target){ head++; }
		if (nums[head] != target) return new int[]{-1,-1};
		while (head <= tail && nums[tail] > target ) { tail--; }
		if (nums[tail] != target) return new int[]{-1,-1};
		return new int[]{head,tail};
	}
}
