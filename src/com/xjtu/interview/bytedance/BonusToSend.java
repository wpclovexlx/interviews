package com.xjtu.interview.bytedance;

import java.util.Scanner;

/*
 * 发奖金：每个人至少100 每个人最多打听到自己相邻的人的奖金 加入公司年限高于另外一个，奖金加100  输入每个人的年限，位置就是输入顺序
 *
 * 输入：第一个数字是 N 总数 随后输入N个数
 * 输出：需要发的奖金总数
 * 4
 * 3 9 2 7
 * 输出 600[100 200 100 200]
 * 5
 * 5 4 3 2 1
 * 输出 1500[500 400 300 200 100]
 *
 * */
public class BonusToSend {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        if (count == 1) {
            int a = in.nextInt();
            System.out.println(100);
            System.exit(1);
        }
        int[] years = new int[count];
        for (int i = 0; i < count; i++) {
            years[i] = in.nextInt();
        }
        int[] bouns = bounsToSend(years);
        int counts = 0;
        for (int i : bouns) {
            counts += i;
        }
        System.out.println(counts);
    }

    public static int[] bounsToSend(int[] years) {
        int[] bouns = new int[years.length];
        for (int i = 0; i < years.length; i++) {
            bouns[i] = 100;
        }
        for (int i = 0; i < years.length; i++) {
            if (i == 0) {
                if (years[0] < years[1]) {
                    bouns[1] = bouns[0] + 100;
                }
            } else if (i == years.length - 1) {
                if (years[years.length - 1] > years[years.length - 2]) {
                    bouns[years.length - 1] = bouns[years.length - 2] + 100;
                }
            } else {
                if (years[i] > years[i - 1]) {
                    if (bouns[i] <= bouns[i - 1]) {
                        bouns[i] = bouns[i - 1] + 100;
                    }
                }
                if (years[i] > years[i + 1]) {
                    if (bouns[i] <= bouns[i + 1]) {
                        bouns[i] = bouns[i + 1] + 100;
                        for (int j = i; j > 0; j--) {
                            if (years[j - 1] > years[j]) {
                                if (bouns[j - 1] <= bouns[j]) {
                                    bouns[j - 1] = bouns[j] + 100;
                                }
                            }
                        }
                    }
                }
            }

        }
        return bouns;
    }
}
