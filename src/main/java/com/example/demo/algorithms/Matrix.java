package com.example.demo.algorithms;

public class Matrix {
    //初始化一个随机nxn阶矩阵
    public static int[][] initializationMatrix(int n, int m) {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = (int) (Math.random() * 10); //采用随机函数随机生成1~10之间的数
            }
        }
        return result;
    }

    //蛮力法求解两个nxn和nxn阶矩阵相乘
    public static int[][] BruteForce(int[][] p, int[][] q, int n, int m) {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    result[i][j] += p[i][k] * q[k][j];
                }
            }
        }
        return result;
    }

    //控制台输出矩阵
    public static void PrintfMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print("\t");
                System.out.print(matrix[i][j]);
            }
        }

    }


    public static int[][] MatrixMultiply(int[][] a, int[][] b) {
        int n = a.length;
        int m = a[0].length;
        int k = b[0].length;
        int[][] result = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                result[i][j] = 0;
                for (int t = 0; t < m; t++) {
                    int aTmp = a[i][t];
                    int bTmp = b[t][j];
                    result[i][j] += aTmp * bTmp;
                }
            }
        }
        return result;
    }


    public static void main(String args[]) {
        int[][] a = initializationMatrix(2, 3);
        int[][] b = initializationMatrix(3, 4);
        MatrixMultiply(a, b);
//
//        int[][] bf_result = BruteForce(p,q,4);
//        System.out.println();
//        System.out.print("蛮力法计算矩阵p*q结果为：");
//        PrintfMatrix(bf_result,4);
//
//        int[][] dac_result = DivideAndConquer(p,q,4);
//        System.out.println();
//        System.out.print("分治法计算矩阵p*q结果为：");
//        PrintfMatrix(dac_result,4);
    }
}
