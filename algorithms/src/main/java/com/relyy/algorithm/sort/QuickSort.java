package com.relyy.algorithm.sort;

/**
 * 快速排序 最好时间O(nlgn) 最坏O(n^2) 不稳定
 * @author cairuirui
 * @create 2018/9/26
 */
public class QuickSort {

    public static void main(String[] args) {
            Integer[] arr = {1,6,2,7,9,3,4,5,10,8};
            sort(arr,0,arr.length-1);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }


    public static void sort(Integer[] arr,int beginIndex,int endIndex){
        if (endIndex <= beginIndex){
            return;
        }
        int standard = getStandard(arr, beginIndex, endIndex);
        sort(arr,beginIndex,standard - 1);
        sort(arr,standard + 1,endIndex);
    }

    private static int getStandard(Integer[] arr,int beginIndex,int endIndex){
        int i = beginIndex + 1;
        int j = endIndex;
        int temp = arr[beginIndex];
        while (true) {

            while (arr[i] < temp) {
                i++;
                if (i == endIndex){
                    break;
                }
            }

            while (arr[j] > temp) {
                j--;
                if (j == beginIndex){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            Integer p = arr[i];
            arr[i] = arr[j];
            arr[j] = p;
        }
        arr[beginIndex] = arr[j];
        arr[j] = temp;
        return j;
    }
}
