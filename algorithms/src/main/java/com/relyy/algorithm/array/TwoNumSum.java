package com.relyy.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 */
public class TwoNumSum {

	public static void main(String[] args) {
		int[] arr = {3,2,4};
		int target = 6;

		int[] result1 = enumMethod(arr, target);
		int[] result2 = minusMethod(arr, target);
	}

	private static int[] enumMethod(int[] arr, int target) {
		int length = arr.length;
		for (int headIndex = 0; headIndex < length - 1; headIndex++){
			for (int j = headIndex+1; j < length; j++){
				if(arr[headIndex] + arr[j] ==target){
					System.out.println(headIndex+","+j);
					return new int[]{headIndex,j};
				}
			}
		}
		return null;
	}

	private static int[] minusMethod(int[] arr, int target) {
		int length = arr.length;
		HashMap<Integer, Integer> map = new HashMap<>(length);
		//ArrayList<Integer> list = new ArrayList<>();采用ArrayList也可以，但是由于会有扩容，会增加空间复杂度
		for (int headIndex = 0; headIndex < length; headIndex++){
			map.put(arr[headIndex],headIndex);
		}

		for (int i = 0; i < length; i++){
			int num = target - arr[i];
			if (map.containsKey(num)){
				Integer index = map.get(num);
				if (i != index) {
					System.out.println(i + "," + index);
					return new int[]{i, index};
				}
			}
		}

		/** 简化方法
		for (int headIndex = 0; headIndex < length; headIndex++){
			if (map.containsKey(arr[headIndex])){
				System.out.println(headIndex + "," + map.get(headIndex));
				return new int[]{headIndex, map.get(headIndex)};
			}
			map.put(arr[headIndex],headIndex);
		}
		*/
		return null;
	}
}
