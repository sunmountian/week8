package com.ArrayList;

/**
 * @version 1.0
 * @authoe 李祥基
 * leetcode 59
 */
public class GenerateMatrix {
    static class Solution {
        public int[][] generateMatrix(int n) {
            int [][] res = new int[n][n];
            // 定义每循环一个圈的起始位置
            int startx = 0 , starty = 0 ;
            // 需要控制每一条边遍历的长度，每次循环右边界收缩一位
            int offset = 1 , loop = 0 ;
            int count = 1;
            int i , j ;
            while (loop++ < n / 2){
                // 下面开始的四个for就是模拟转了一圈
                // 模拟填充上行从左到右(左闭右开)
                for (j = starty ; j < n - offset ; j++){
                    res[startx][j] = count++;
                }
                // 模拟填充右列从上到下(左闭右开)
                for (i = startx ; i < n -offset ; i++){
                    res[i][j] = count++;
                }
                // 模拟填充下行从右到左(左闭右开)
                for (;i > startx ; i--){
                    res[i][j] = count++;
                }
                // 模拟填充左列从下到上(左闭右开)
                for (; j > starty ; j--){
                    res[i][j] = count++;
                }
                // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
                startx++;
                starty++;
                // offset 控制每一圈里每一条边遍历的长度
                offset+=1;
            }
            // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
            if (n % 2 == 1){
                res[n / 2][n / 2] = count;
            }
            return res;
        }
    }
}

