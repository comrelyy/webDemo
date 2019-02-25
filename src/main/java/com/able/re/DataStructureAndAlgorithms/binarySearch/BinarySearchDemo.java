package com.able.re.DataStructureAndAlgorithms.binarySearch;

import static java.util.Arrays.binarySearch;

/**
 * $二分算法
 *
 * @author cairuirui
 * @create 2018/12/7
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};

        //java.util.Arrays.binarySearch;
        //Integer value = binarySearch(arr,9);
        Integer value = binarySearchMyself(arr,7);
        System.out.println(value);
    }

    private static Integer binarySearchMyself(Integer[] arr, int i) {
        int length = arr.length;
        int lower = 0;
        int higher = length;

        while (lower < higher){
            int middle = (higher - lower) / 2 + lower;
            if (arr[middle] == i){
                return middle;
            } else if (arr[middle] > i){
                higher = middle;
            }else {
                lower = middle;
            }
        }
        return  -1;
    }
}
