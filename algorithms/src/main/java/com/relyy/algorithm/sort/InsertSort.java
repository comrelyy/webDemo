package com.relyy.algorithm.sort;

/**
 * 插入排序
 * @author cairuirui
 * @create 2018-03-19
 */
public class InsertSort {

    public static void main(String[] args) {
        Integer[] intArr = {9,3,4,2,6,7,5,1};
        //sort(intArr);
        binaryInsertSort(intArr);
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
    }

    /**
     * 直接插入：最好O(n),平均O(n^2)，最坏O(n^2)， 稳定
     * @param arr
     */
    public static void sort(Integer[] arr){
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int j = i-1;
            while (j >= 0){
                if (arr[j] > key){
                    arr[j+1] = arr[j];
                    arr[j] = key;
                }
                j--;
            }
        }
    }

    /**
     * 二分插入 最好O(n),平均O(n^2)，最坏O(n^2)， 稳定
     */
    public static void binaryInsertSort(Integer[] a){
       int length = a.length;
        for (int i = 1; i < length; i++) {
            if (a[i] < a[i-1]) {
                int key = a[i];
                int index = binarySearch(a, key, 0, i - 1);
                for (int j = i-1 ; j >= index; j-- ){
                    a[j+1] = a[j];
                }
                a[index] = key;
            }
        }
    }

    private static int binarySearch(Integer[] a,int target,int start,int end){
       int mid;
       while (start <= end){
           mid = (start + end + 1) >> 1; //除以2 右移一位
           if(a[mid] > target){
               end = mid - 1;
           }else {
               start = mid + 1;
           }
       }
       return start;
    }
}
