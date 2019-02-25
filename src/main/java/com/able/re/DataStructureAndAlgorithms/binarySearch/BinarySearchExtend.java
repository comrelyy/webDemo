package com.able.re.DataStructureAndAlgorithms.binarySearch;

/**
 * 二分查找变形
 *
 * @author cairuirui
 * @create 2018/12/5
 */
public class BinarySearchExtend {
    public static void main(String[] args) {
        Integer[] arr = {1,3,4,5,6,8,8,8,11,18};
        //Integer firstGTNum = findFirstGTNum(arr, 8);
        //Integer lastGTNum = findLastEqNum(arr, 8);
        //Integer firstGTNum = findFirstGTNum(arr, 10);
        Integer lastITNum = findLastITNum(arr, 6);
        System.out.println(lastITNum);
    }

    /**
     * 查找第一个等于给定值的角标
     * @param arr
     * @param value
     * @return
     */
    public static Integer findFirstEqNum(Integer[] arr,int value){
        int length = arr.length;
        int lower = 0;
        int higher = length;
        while (lower < higher) {
            int middle = (higher - lower) / 2 + lower;
            if (arr[middle] < value){
                lower = middle;
            }else if(arr[middle] > value){
                higher = middle;
            }else if(arr[middle] == value){
                if (middle == 0 || arr[middle -1] != value){
                    return middle;
                }else {
                    higher = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 获取最后一个等于给定值的角标
     * @param arr
     * @param value
     * @return
     */
    public static Integer findLastEqNum(Integer[] arr,int value){
        int length = arr.length;
        int lower = 0;
        int higher = length;
        while (lower < higher) {
            int middle = (higher - lower) / 2 + lower;
            if (arr[middle] < value){
                lower = middle;
            }else if(arr[middle] > value){
                higher = middle;
            }else if(arr[middle] == value){
                if (middle == 0 || arr[middle + 1] != value){
                    return middle;
                }else {
                    lower = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的角标
     * @param arr
     * @param value
     * @return
     */
    public static Integer findFirstGTNum(Integer[] arr,int value){
        int length = arr.length;
        int lower = 0;
        int higher = length;
        while (lower < higher) {
            int middle = (higher - lower) / 2 + lower;
            if (arr[middle] < value){
                lower = middle;
            }else if(arr[middle] > value){
                if (middle == 0 || arr[middle - 1] < value ){
                    return middle;
                }else {
                    higher = middle - 1;
                }
            }else if(arr[middle] == value){
                if (middle == 0 || arr[middle - 1] != value){
                    return middle;
                }else {
                    higher = middle - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 获取最后一个小于等于给定值的元素的角标
     * @param arr
     * @param value
     * @return
     */
    public static Integer findLastITNum(Integer[] arr,int value){
        int length = arr.length;
        int lower = 0;
        int higher = length;
        while (lower < higher) {
            int middle = (higher - lower) / 2 + lower;
            if (arr[middle] < value){
                if (middle == 0 || arr[middle + 1] > value ){
                    return middle;
                }else {
                    lower = middle + 1;
                }
            }else if(arr[middle] > value){
                higher = middle;
            }else if(arr[middle] == value){
                if (middle == 0 || arr[middle + 1] != value){
                    return middle;
                }else {
                    lower = middle + 1;
                }
            }
        }
        return -1;
    }
}
