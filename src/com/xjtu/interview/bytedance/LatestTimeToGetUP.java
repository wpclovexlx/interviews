package com.xjtu.interview.bytedance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 *
 *
 * 输入:第一行是闹钟的数量（正整数N<=100），接下来N行每行包含两个正整数，表示这个闹钟响起的时间为A时B分，接下来的一行包含一个整数，表示
 * 从起床算起他需要x分钟到达教室， 接下来的一行包含两个整数，表示上课时间为C时D分 数据保证至少一个闹钟可以让其及时到达教室
 * 输出:两个整数表示最晚起床的时间
 * 例子：
 * 输入：
 * 3
 * 5 0
 * 6 0
 * 7 0
 * 59
 * 6 59
 * 输出：
 * 6 0
 *
 * */
public class LatestTimeToGetUP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        if (count == 0) {
            System.out.println(0 + " " + 0);
        }
        int maxTime = 0;
        List<Integer> timeList = new ArrayList<>();
        while (count-- != 0) {
            int hour = in.nextInt();
            int minute = in.nextInt();
            int minutes = hour * 60 + minute;
            timeList.add(minutes);
        }
        int timeToSchool = in.nextInt();
        int hour = in.nextInt();
        int minute = in.nextInt();
        int classTime = hour * 60 + minute;
        int timeToSleep = classTime - timeToSchool;
        for (int a : timeList) {
            if (a <= timeToSleep && a >= maxTime) {
                maxTime = a;
            }
        }
        int hourToLate = maxTime / 60;
        int minuteToLate = maxTime % 60;
        System.out.println(hourToLate + " " + minuteToLate);

    }
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        List<Integer> timeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int hour = in.nextInt();
            int minute = in.nextInt();
            int minutes = hour * 60 + minute;
            timeList.add(minutes);
        }
        int timeToClass = in.nextInt();
        int hour = in.nextInt();
        int minute = in.nextInt();
        if(count == 0){
            System.out.println(0 + " " + 0);
            System.exit(0);
        }
        int ClassTime = hour * 60 + minute;
        int LatestTimeToGetUp = ClassTime - timeToClass;
        Collections.sort(timeList);
        int result = 0;
        for (int i = 1; i < timeList.size(); i++) {
            if (LatestTimeToGetUp >= timeList.get(i - 1) & LatestTimeToGetUp < timeList.get(i)) {
                result = timeList.get(i - 1);
                break;

            }
        }
        if (LatestTimeToGetUp == timeList.get(timeList.size() - 1)) {
            result = timeList.get(timeList.size() - 1);
        }
        int hours = result / 60;
        int minutes = result % 60;
        System.out.println(hours + " " + minutes);


    }*/
}
