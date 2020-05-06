package com.able.re.DataStructureAndAlgorithms;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class RemoveZero {

    public static void main(String[] args) {
        int[] arr = {1,0,0,3,12};
        int length = arr.length;

        int lastNotZero = 0;
            for (int j = 0;j < length;j++){
                if (arr[j] != 0){
                    if (arr[lastNotZero] == 0) {
                        arr[lastNotZero] = arr[j];
                        arr[j] = 0;
                    }
                    lastNotZero++;
                }
            }
//            while (lastNotZero < length){
//                arr[lastNotZero++] = 0;
//            }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
