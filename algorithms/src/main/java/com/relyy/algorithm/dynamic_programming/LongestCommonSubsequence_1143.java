package com.relyy.algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * @Description
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有
 *
 * @Created by cairuirui
 * @Date 2021/11/1
 */
public class LongestCommonSubsequence_1143 {

	public static void main(String[] args) {
		String text1 = "delete",text2 = "leet";
		int longest = dpSolution(text1,text2);
		System.out.println(longest);
	}


	private static int selfSolution(String text1, String text2) {

		/**
		 * dp[i]标识 最短字符串s中sub（0，i）与 较长字符串l的公共子串长度
		 * 初始值都是0
		 *
		 * dp[i+1]=dp[i]+1 成立的条件
		 *  s[i+1] 再 l中存在 且 再l中的位置大于 s[i] 再 l中的位置
		 * 错误思路
		 */

		String longs;
		String shorts;
		if (text1.length() >= text2.length()) {
			longs = text1;
			shorts = text2;
		}else {
			longs = text2;
			shorts = text1;
		}

		char[] longArr = longs.toCharArray();
		char[] shortArr = shorts.toCharArray();

		int[] dp = new int[shortArr.length];
		int longest = 0;
		Arrays.fill(dp,0);
		int lastIndex = -1;
		if (longs.contains(shorts.substring(0,1))){
			dp[0] = 1;
			longest = 1;
			lastIndex = longs.indexOf(shorts.substring(0,1));
		}
		for (int i = 1; i < shortArr.length; i++) {
			for (int j = lastIndex + 1; j < longArr.length; j++) {
				if (longArr[j] == shortArr[i]){
					if (j > lastIndex){
						dp[i] = dp[i - 1] + 1;
						lastIndex = j;
						break;
					}
				}
			}
			longest = Math.max(dp[i],longest);
		}
		return longest;
	}

	private static int dpSolution(String text1, String text2) {
		/**
		 * dp[i][j]表示 text1[0:i-1]与text2[0:j-1]之间的最长公共子串
		 *
		 * dp[i][j] = dp[i-1][j-1]+ 1 当text1[i-1] == text2[j-1]时，说明：
		 *     text1[i-1] == text2[j-1]表示两个字符串最后一位相同，该字符肯定是公共字符串的元素，
		 *     所以两个字符串都减去一位，如果能求出同时减去一位之后两个字符串的最长公共子串，那么加上最后一位，就是题目要求的最终结果
		 *
		 * dp[i][j] = max{dp[i-1][j],dp[i][j-1]} 当text1[i-1] != text2[j-1]时，谁能使公共序列变长，谁就不需要减一
		 *
		 */

		int m = text1.length();
		int n = text2.length();

		int[][] dp = new int[m+1][n+1];
		for (int i = 0; i <= m; i++) {
			Arrays.fill(dp[i],0);
		}

		char[] mArr = text1.toCharArray();
		char[] nArr = text2.toCharArray();

		for (int i = 1; i <=m; i++) {
			for (int j = 1; j <=n; j++) {
				if (nArr[j-1] == mArr[i-1]){
					dp[i][j] = dp[i - 1][j - 1]+1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
 				}
			}
		}
		return dp[m][n];
	}

	private static int exhaustionSolution(String text1, String text2) {


		return 0;
	}
}
