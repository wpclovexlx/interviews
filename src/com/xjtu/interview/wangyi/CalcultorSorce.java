package com.xjtu.interview.wangyi;

import java.util.*;

public class CalcultorSorce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入人数");
        int n = sc.nextInt();
        if (n == 0) {
            throw new RuntimeException("请输入人数");
        }
        int[] scores = new int[n];
        System.out.println("请输入每个人的分数");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        System.out.println("请输入查询的人数");
        int queryCount = sc.nextInt();
        int[] queryPerson = new int[queryCount];
        System.out.println("请输入查询第几个人的分数");
        for (int i = 0; i < queryCount; i++) {
            queryPerson[i] = sc.nextInt();
        }
        for (int i = 0; i < queryPerson.length; i++) {
            int score = scores[queryPerson[i] - 1];
            int count = 0;
            for (int j = 0; j < scores.length; j++) {
                if (score <= scores[j]) {
                    count++;
                }
            }
            double percent = (double) (count - 1) / n * 100;
            System.out.println(String.format("%.6f", percent));
        }
    }
}
