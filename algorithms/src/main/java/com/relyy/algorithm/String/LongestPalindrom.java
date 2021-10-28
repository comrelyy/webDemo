package com.relyy.algorithm.String;

/**
 * @Description 最长回文字符串
 * @Created by cairuirui
 * @Date 2021/10/28
 */
public class LongestPalindrom {

	public static void main(String[] args) {
		String s = "aacabdkacaa";
		String longestPalindrom = solution(s);
		System.out.println(longestPalindrom);
	}



	private static String solution(String s) {
		int length = s.length();
		if (length == 1)
			return s;

		String lp = "";
		for (int i = 1; i < length; i++) {
			String tmp = palindrome(s,lp,i);
			lp = lp.length() > tmp.length() ? lp : tmp;
		}
		return lp;
	}

	private static String palindrome(String s,String sub, int i) {
		int longest = sub.length();
		int index = 0;

		while (index < i){
			if (s.charAt(i) == s.charAt(index)) {
				break;
			}
			index++;
		}

		if (s.substring(index,i+1).length() <= longest) return sub;
		int left = index;
		int right = i;
		while (left <= right){
			if (s.charAt(left) != s.charAt(right)) {
				return sub;
			}
			left ++;
			right --;
		}
		return s.substring(index,i+1);
	}
}
