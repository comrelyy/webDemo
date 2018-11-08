package com.able.re.sort;

import java.util.Arrays;

/**
 * 归并排序-分而治之 稳定的排序 时间复杂度O(nlogn)
 * @author cairuirui
 * @create 2018/11/8
 */
public class MergeSortDemo {

    public static void main(String[] args) {

        Integer[] arr = {4,6,8,5,9,11,3,1,2,7,10};
        int length = arr.length;
        Integer[] temp = new Integer[length];
        sort(arr,0,length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(Integer[] arr,int left,int right,Integer[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(Integer[] arr,int left,int mid,int right,Integer[] temp){
        int index = 0;
        int i = left;
        int j = mid + 1;

        //对比左右元素数据
        while (i <= mid && j <= right){
            if (arr[i] > arr[j]){
                temp[index++] = arr[j++];
            }else {
                temp[index++] = arr[i++];
            }
        }

        //将左边剩余的加入临时数组
        while (i <= mid){
            temp[index++] = arr[i++];
        }
        //将右边剩余的加入临时数组
        while (j <= right){
            temp[index++] = arr[j++];
        }

        //将临时数组的数据复制到原数组
        int t = 0;
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }
}
