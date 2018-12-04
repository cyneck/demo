package com.example.demo.algorithms;

/**
 * Package : com.example.demo.algorithms
 * Description : 求两个字符串的最长公共子字符串,矩阵求解
 * Create on : 2018/12/4 18:42 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "DSGSHSRGSRHTRD";
        String str2 = "DATRGAGTSHS";
        String lcs = getLCS(str1, str2);

        //Print LCS
        if (lcs != null) {
            System.out.println("String 1: " + str1);
            System.out.println("String 2: " + str2);
            System.out.println("LCS: " + lcs);
            System.out.println("LCS length: " + lcs.length());
        }
    }

    public static String getLCS(String str1, String str2) {

        if (str1 == null || str2 == null)
        {
            return null;
        }

        if (str1.length() == 0 || str2.length() == 0)
        {
            return "";
        }

        String[] rowsArray = str1.split("");
        String[] colsArray = str2.split("");

        //lcsMatrix[i][j] ，
        int[][] lcsMatrix = new int[rowsArray.length + 1][colsArray.length + 1];

        for (int i = 0; i < rowsArray.length + 1; i++)
            lcsMatrix[i][0] = 0;
        for (int j = 1; j < colsArray.length + 1; j++)
            lcsMatrix[0][j] = 0;
        for (int i = 1; i < rowsArray.length + 1; i++) {
            for (int j = 1; j < colsArray.length + 1; j++) {
                if (rowsArray[i - 1].equals(colsArray[j - 1])) {
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                } else {
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j] > lcsMatrix[i][j - 1] ? lcsMatrix[i - 1][j] : lcsMatrix[i][j - 1];
                }
            }
        }
        return lcsString(str1, str2, lcsMatrix);
    }

    public static String lcsString(String str1, String str2, int[][] lcsMatrix) {
        StringBuilder lcs = new StringBuilder();
        int i = str1.length(),
                j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (lcsMatrix[i - 1][j] > lcsMatrix[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs.reverse().toString();
    }

}
