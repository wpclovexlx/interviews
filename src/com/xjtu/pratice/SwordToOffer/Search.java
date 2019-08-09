package com.xjtu.pratice.SwordToOffer;

/*
 * 二维数组中的查找
 * */
public class Search {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int b = 5;
        Find(b, a);
    }

    private static boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        for (int i = rows - 1, j = 0; i >= 0 & j < cols; ) {
            if (target < array[i][j]) {
                i--;

            } else if (target > array[i][j]) {
                j++;

            } else {
                return true;
            }
        }
        return false;
    }
}
