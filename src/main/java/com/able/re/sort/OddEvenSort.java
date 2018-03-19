package com.able.re.sort;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-03-19
 */
public class OddEvenSort {

    public static void main(String[] args) {
        int[] intArr = {9,3,4,2,6,7,5,1};
        sort(intArr);
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
    }


    public static void sort(int[] arr){

        int length = arr.length;
        boolean oddsort = false;
        boolean evensort = false;

        while (!oddsort || !evensort){
            int base = 0;
            oddsort = true;
            evensort = true;

            for (int i = base; i < length - 1 ; i +=2) {
                if (arr[i] > arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    oddsort = false;
                }
            }

            base = 1;

            for (int i = base; i < length - 1 ; i +=2) {
                if (arr[i] > arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    evensort = false;
                }
            }
        }
    }
}
