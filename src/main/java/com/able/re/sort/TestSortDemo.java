package com.able.re.sort;

/**
 * 找到排序的最大值n，申请一个容量为n的数组，按照数字大小插入到响应的下标中
 *
 * @author cairuirui
 * @create 2018/11/4
 */
public class TestSortDemo {

    public static void main(String[] args) {
        Integer[] arr = {6,1,2,7,9,3,4,5,10,8,16};
        sortDemo(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }

    private static void sortDemo(Integer[] arr) {
        Integer max = getMax(arr);
        Integer[] newArr = new Integer[max+1];
        for (Integer integer : arr) {
            newArr[integer] = integer;
        }

        int i = 0;
        for (Integer integer : newArr) {
            if (null != integer){
                arr[i++] = integer;
            }
        }
        newArr = null;
    }

    private static Integer getMax(Integer[] arr) {
        Integer num = 0;
        for (Integer integer : arr) {
            if (integer > num) {
                num = integer;
            }
        }
        return num;
    }
}


