package com.able.re.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author cairuirui
 * @create 2018-03-27
 */
public class HeapSortDemo {

    public static void main(String[] args) {

        int []arr = {4,6,8,5,9,11,3,1,2,7,10};
        int length = arr.length;
        int size = length - 1;

        while (size > 0) {
            for (int i = size; i >= 0; i--) {
                sort(arr, i, size+1);
            }

            swap(arr, 0, size);
            System.out.println(Arrays.toString(arr));
            size--;
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int arr[],int currentNote,int size){
        int left = currentNote * 2 + 1;
        int right = currentNote * 2 + 2;

        int index = currentNote;

        if (left < size){
            if (arr[index] < arr[left]){
                index = left;
            }
        }

        if (right < size){
            if (arr[index] < arr[right]){
                index = right;
            }
        }

        if (index != currentNote){
            swap(arr,index,currentNote);
            //sort(arr,index,size);
        }
    }

    public static void swap(int arr[],int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
