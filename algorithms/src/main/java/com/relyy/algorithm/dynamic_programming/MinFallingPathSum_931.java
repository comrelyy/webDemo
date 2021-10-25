package com.relyy.algorithm.dynamic_programming;

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
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int result = solution(matrix);
        System.out.println(result);
    }

    private static int solution(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        //计算matrix[][]最小路径和就是需要遍历j
        int dbResult = Integer.MAX_VALUE;
        //定义db函数
        for (int j = 0 ; j < matrix.length; j++) {
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
        if (j >= matrix.length) return 9999;
        if (i == 0){
            return matrix[0][j];
        }

        if (j == 0){
            return matrix[i][j] + db(matrix,i - 1,j);
        }


        return matrix[i][j] + Math.min(Math.min(db(matrix, i - 1, j-1),
                                        db(matrix, i - 1, j)),
                                        db(matrix,i-1,j+1));


    }
}
