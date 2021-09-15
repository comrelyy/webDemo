package com.relyy.algorithm.array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class removeDuplicates {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int target = nums[0];

        int lastNotSameNum = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++){
            if (target != nums[i]){
                lastNotSameNum ++;
                nums[lastNotSameNum] = nums[i];
                target = nums[i];
                count = 0;
            }else {
                count++;
                if (count < 2) {
                    lastNotSameNum++;
                    nums[lastNotSameNum] = nums[i];
                }
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
