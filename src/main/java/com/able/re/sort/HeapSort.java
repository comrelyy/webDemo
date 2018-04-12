package com.able.re.sort;

/**
 * 堆排序
 * Created by relyy on 2018/3/26.
 */
public class HeapSort {

    public static void main(String[] args) {

    }

    private static void sort(int[] arr,int index,int size) {

        if (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            int currentNode = index;
            if (left < size) {
                if (arr[index] < arr[left]) {
                    index = left;
                }
            }

            if (right < size) {
                if (arr[index] < arr[right]) {
                    index = right;
                }
            }

            if (index != currentNode){
                int tmp = arr[currentNode];
                arr[currentNode] = arr[index];
                arr[index] = tmp;
            }
        }
    }
}
