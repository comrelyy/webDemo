package com.relyy.algorithm.sort;

/**
 * 选择排序
 * 最好O(n^2),平均O(n^2)，最坏O(n^2)， 不稳定
 * @author cairuirui
 * @create 2018/9/12
 */
public class SelectSort {

    public static void main(String[] args) {
        Integer[] intArr = {9,3,4,2,6,7,5,1};
        sort(intArr);
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
    }

    public static void sort(Integer[] arr){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i; j < length; j++){
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
}
