package com.relyy.algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * @Description
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，
 * 每步可以删除任意一个字符串中的一个字符。
 * @Created by cairuirui
 * @Date 2021/11/2
 */
public class MinDistanceDelChar_583 {

	public static void main(String[] args) {
		String word1 = "delete", word2="leet";
		int minDistance = dpSolution(word1,word2);
		System.out.println(minDistance);
		int minDistanceAsciiSum = minimumDeleteSum(word1,word2);
		System.out.println(minDistanceAsciiSum);
	}

	private static int dpSolution(String word1, String word2) {
		//word1 与 word2 从题目看可能是空串，那么需要的步数应该是 非空字符串的长度
		int w1Length = word1.length();
		int w2Length = word2.length();
		if (w1Length == 0 && w2Length == 0){
			return 0;
		}
		if (w1Length == 0){
			return w2Length;
		}
		if (w2Length == 0){
			return w1Length;
		}
		// word1 与 word2 不存在公共字符串，那么最大步数是word1与word2长度之和

		// dp[i][j] 标识 word1[0,i-1] 与word2[0,j-1]之间需要删除的元素
		// 初始值为 dp[i][j] = word1.length + word2.length
		int[][] dp = new int[w1Length+1][w2Length+1];
		for (int i = 0; i <= w1Length; i++) {
			Arrays.fill(dp[i], w1Length + w2Length);
		}
		char[] w1Char = word1.toCharArray();
		char[] w2Char = word2.toCharArray();
		// if word1[i] == word2[j] 则 dp[i][j] = dp[i-1][j-1]-1
		// if word1[i] != word2[j] 则 dp[i][j] = min{dp[i-1][j],dp[i][j -1]}
		for (int i = 1; i <= w1Length; i++) {
			for (int j = 1; j <= w2Length; j++) {
				if (w1Char[i-1] == w2Char[j-1]){
					dp[i][j] = dp[i-1][j-1] - 2;
				}else {
					dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
		return dp[w1Length][w2Length];
	}

	//两个字符串的最小ASCII删除和——712
	//求删除字符ASCII和的最小值 转化为求保留字符串的ASCII的最大值
	// 也就是求可以两个字符串公共子序列且ASCII最大值，利用两个字符串ASCII总和减去公共子序列的最大ASCII最大值
	private static int minimumDeleteSum(String word1, String word2) {
		//word1 与 word2 从题目看可能是空串，那么需要的步数应该是 非空字符串的长度
		int w1Length = word1.length();
		int w2Length = word2.length();
		if (w1Length == 0 && w2Length == 0){
			return 0;
		}

		char[] w1Char = word1.toCharArray();
		int w1Sum = getCharSum(word1);
		char[] w2Char = word2.toCharArray();
		int w2Sum = getCharSum(word2);

		if (w1Length == 0){
			return w2Sum;
		}
		if (w2Length == 0){
			return w1Sum;
		}
		// word1 与 word2 不存在公共字符串，那么最大步数是word1与word2长度之和

		// dp[i][j] 标识 word1[0,i-1] 与word2[0,j-1]之间需要删除的元素
		// 初始值为 dp[i][j] = word1.length + word2.length
		int[][] dp = new int[w1Length+1][w2Length+1];
		for (int i = 0; i <= w1Length; i++) {
			Arrays.fill(dp[i], 0);
		}
		for (int i = 1; i <= w1Length; i++) {
			for (int j = 1; j <= w2Length; j++) {
				if (w1Char[i-1] == w2Char[j-1]){
					dp[i][j] = dp[i-1][j-1] + (w1Char[i-1]- 0) + (w2Char[j-1] - 0);
				}else {
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
		return w1Sum + w2Sum - dp[w1Length][w2Length];
	}

	private static int getCharSum(String s){
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		int baseValue =  97;
		int length = s.length();
		int sum = baseValue * length;
		for (int i = 0; i < length; i++) {
			if (s.charAt(i) == ' ')continue;
			sum += alpha.indexOf(s.charAt(i));
		}

		return sum;
	}
}
