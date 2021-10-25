package com.relyy.algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1)
 *
 */
public class MinFallingPathSum_931 {


    public static void main(String[] args) {
        int[][] matrix = {{100,-42,-46,-41},
                            {31,97,10,-10},
                            {-58,-51,82,89},
                            {51,81,69,-51}};
        int result = solution(matrix);
        System.out.println(result);
    }

    static private int[][] memo;
    private static int solution(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        memo = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(memo[i],9999);
        }

        //计算matrix[][]最小路径和就是需要遍历j
        int dbResult = Integer.MAX_VALUE;
        //定义db函数
        for (int j = 0 ; j < matrix.length; j++) {
            System.out.println(db(matrix, matrix.length - 1, j));
            dbResult = Math.min(db(matrix, matrix.length-1, j),dbResult);
        }
        return dbResult;
    }

    /**
     * db函数计算 matrix[0][...] 到 matrix[i][j] 的最小下降路径和
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    private static int db(int[][] matrix, int i, int j) {
        if (j >= matrix.length || j < 0 ) return 9999;

        if (memo[i][j] != 9999){
            return memo[i][j];
        }

        if (i == 0){
            memo[i][j] = matrix[0][j];
            return matrix[0][j];
        }

//        if (j == 0){
//            return matrix[i][j] + db(matrix,i - 1,j);
//        }
        memo[i][j] = Math.min(matrix[i][j] + Math.min(Math.min(db(matrix, i - 1, j-1),
                db(matrix, i - 1, j)),
                db(matrix,i-1,j+1)),memo[i][j]);

        return memo[i][j];


    }
}
