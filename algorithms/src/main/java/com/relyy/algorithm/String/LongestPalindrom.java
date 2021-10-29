package com.relyy.algorithm.String;

import java.util.Arrays;

/**
 * @Description 最长回文字符串
 * @Created by cairuirui
 * @Date 2021/10/28
 */
public class LongestPalindrom {

	public static void main(String[] args) {
		String s = "abacab";
		String longestPalindrom = dbSolution(s);
		System.out.println(longestPalindrom);
	}


	/**
	 * 滑动窗口
	 * @param s
	 * @return
	 */
	private static String exhaustionSolution(String s) {
		int length = s.length();
		if (length == 1)
			return s;

		String lp = s.substring(0,1);
		for (int i = 1; i < length; i++) {
			String tmp = palindrome(s,lp,i);
			lp = lp.length() > tmp.length() ? lp : tmp;
		}
		return lp;
	}

	private static String palindrome(String s,String sub, int i) {
		int left = 0;
		int right = i;
		char[] chars = s.toCharArray();
		while (right < chars.length){
			if (chars[left] == chars[right]){
				if (isPalindromeStr(s.substring(left,right+1))){
					return s.substring(left,right+1);
				}
			}
			left++;
			right++;
		}

		return sub;
	}

	private static boolean isPalindromeStr(String substring) {
		return PalindromicSubStringDemo.isPalindromicSubString(substring);
	}

	/**
	 * 动态规划解
	 * @param s
	 * @return
	 */
	public static String dbSolution(String s){
		/**
		 * 状态 dp[i][j] 表示 s[i] 到 s[j]是否为回文字符串
		 * 状态转移 dp[i][j] = db[i+1][j-1] && s[i] == s[j]
		 * basecase j - i < 3时 是否有 s[i] == s[j] ,也就是当只有两个字符时s[i] == s[i+1] ,因为只有一个字符时必然是回文字符串
		 */
		int length = s.length();
		if (length == 1)
			return s;

		boolean db[][] = new boolean[length][length];
		for (int i = 0; i < length; i++) {
			db[i][i] = true;
		}

		int longest = 1;
		int begin = 0;

		char[] chars = s.toCharArray();
		for (int j = 1; j < length;j++){

			for (int i = 0; i < j;i++){

				if (chars[i] != chars[j]){
					db[i][j] = false;
				}else {
					if (j - i < 3){
						db[i][j] = true;
					}else {
						db[i][j] = db[i+1][j-1];
					}
				}

				if (db[i][j] && (j - i + 1 > longest)){
					longest = j - i + 1;
					begin = i;
				}
			}
		}

		return s.substring(begin,begin + longest);
	}

}
