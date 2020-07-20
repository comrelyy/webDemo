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
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ints = greedyMerge(intervals);
        for (int[] anInt : ints) {
            System.out.print("{");
            for (int i : anInt) {
                System.out.print(i+",");
            }
            System.out.println("}");
        }
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
}
