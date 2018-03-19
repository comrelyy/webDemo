package com.able.re.sort;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-19
 */
public class InsertSort {

    public static void main(String[] args) {
        Integer[] intArr = {9,3,4,2,6,7,5,1};
        sort(intArr);
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
    }

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
}
