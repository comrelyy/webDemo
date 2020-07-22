package com.able.re.DataStructureAndAlgorithms.graph;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 给出一个区间集合，合并所有重叠的区间
 * 输入：[[1,3],[2,6],[8,10],[15,18]] 输出：[[1,6],[8,10],[15,18]]
 * 输入：[[1,4],[4,5]]  输出：[[1,5]]
 */
public class MergeArea {

    /**分析区间之间的关系，给定区间A，B
     * 1 A，B 没有重合，不发生合并
     * 2 A,B有重合且区间B是A的子集，则合并后的区间其实就是区间A
     * 3 A，B有重合，A不包含B,则区间的末端取A,B中的最大值
     * */
    public static void main(String[] args) {
        //int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = {{1,5},{2,3},{3,4},{15,18}};
//        int[][] ints = greedyMerge(intervals);
//        for (int[] anInt : ints) {
//            System.out.println(Arrays.toString(anInt));
//        }
        System.out.println(eraseOverlapIntervals(intervals));
    }

    //1 将所有区间的起始值按照重小到大排序，遍历所有区间后合并----贪婪算法
    private static int[][] greedyMerge(int[][] intervals){
        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[0],i2[0]));

        int[] previous = null;
        List<int[]> result = Lists.newArrayList();

        for (int[] interval : intervals) {
            if (previous == null || interval[0] > previous[1]) {
                result.add(previous = interval);
            }else {
                previous[1] = Math.max(previous[1],interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    /**
     * 变体：
     *  给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠
     *  示例：
     *  输入：   [[1,2],[2,3],[3,4],[1,3]]
     *  输出：1
     *  移除[1,3]后，剩余区间无重叠
     */

    //暴力法
    public static int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[0],i2[0]));
        return eraseOverlapIntervals(-1,0,intervals);
    }

    private static int eraseOverlapIntervals(int prev, int curr, int[][] intervals) {
        if (curr == intervals.length) {
            return 0;
        }
        //如果保留当前区间 最少需要删除多少其他区间
        int taken = Integer.MAX_VALUE;
        //如果删除当前区间，最少要删除多少区间
        int notTaken;
        if (prev == -1 || intervals[prev][1] <= intervals[curr][0]){
            //只有pre与curr之间没有重合，才可以选择保存当前区间
            taken = eraseOverlapIntervals(curr, curr + 1, intervals);
        }
        //其他情况，如果考虑删除当前区间，看看是否会产生其他更好的效果
        notTaken = eraseOverlapIntervals(prev, curr + 1, intervals) + 1;
        return Math.min(taken,notTaken);
    }

    /**
    * 贪婪法1
    * */
    public static int greedyEraseOverlapIntervals(int[][] intervals){
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[0],i2[0]));

        //记录当前已经遍历过的区间中最小的结束值
        int end = intervals[0][1];
        //记录到目前为止删除了多少区间
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                end = Math.min(end,intervals[i][1]);
                count ++;
            }else {
                end = intervals[i][1];
            }
        }

        return count;
    }

    /**
     * 贪婪法：按区间的截止位置从小到大排序，给出的区间中有多少个区间是重叠的
     */
    public static int greedyEraseOverlapIntervals2(int[][] intervals){
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[1],i2[1]));

        int end = intervals[0][1];
        int count = 1;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

}
