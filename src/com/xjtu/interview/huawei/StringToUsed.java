package com.xjtu.interview.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/*
 * input：@前边为全量字符数，后边为已占用字符数
 * return：未使用字符数
 *
 * */
public class StringToUsed {
    public static void main(String[] args) {
        StringUsed("a:3,b:5,c:2@a:3,b:2,c:1");
    }

    private static void StringUsed(String str) {

        //没有已占用字符串
        if (str.length() == str.indexOf("@") + 1) {
            System.out.print(str);
            return;
        }

        //输入字符串按照@分成两个数组
        String[] charSplit = str.split("@");

        //全量字符串按照","分成数组
        String[] allChar = charSplit[0].split(",");

        //已占用字符串按照","分成数组
        String[] HasoccupiedChar = charSplit[1].split(",");

        //没有全量字符集
        if (charSplit[0] == null & charSplit[1] == null) {
            System.out.print("@");
            return;
        }
        //存放输出的结果
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < allChar.length; i++) {
            for (int j = 0; j < HasoccupiedChar.length; j++) {
                if (allChar[i].substring(0, 1).equals(HasoccupiedChar[j].substring(0, 1))) {
                    Integer value = Integer.parseInt(allChar[i].substring(allChar[i].length() - 1)) - Integer.parseInt(HasoccupiedChar[j].substring(HasoccupiedChar[j].length() - 1));
                    //全量字符串 - 已占用字符串 = 0 时不输出
                    /*if (value == 0) {
                        break;
                    }*/
                    map.put(allChar[i].substring(0, 1), value);
                    break;


                } else {
                    map.put(allChar[i].substring(0, 1), Integer.parseInt(allChar[i].substring(allChar[i].length() - 1)));
                }

            }
        }
        //数组拼接
        StringBuilder sb = new StringBuilder();
        Set<String> set = map.keySet();
        for (String s : set) {
            sb.append(s + ":" + map.get(s) + ",");

        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
    //迭代器遍历
        /*Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (!it.hasNext()) {
                System.out.print(entry.getKey() + ":" + entry.getValue());
            } else {
                System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
            }
        }
    }*/
}
