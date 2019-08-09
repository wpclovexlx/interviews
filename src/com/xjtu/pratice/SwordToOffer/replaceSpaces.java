package com.xjtu.pratice.SwordToOffer;

/*
 * 字符串替换
 * */
public class replaceSpaces {
    public static void main(String[] args) {
        String sb = "we are family";
        System.out.println(replaceSpace(sb, " ", "%20"));


    }

    private static String replaceSpace(String originString, String target, String replace) {
        int j = originString.indexOf(target);
        if (j < 0) {
            return originString;
        }
        //替换目标的长度
        int tarLen = target.length();
        //原字符串的长度
        int oriLen = originString.length();

        int newStringLen = oriLen - tarLen + replace.length();
        if (newStringLen < 0) {
            throw new NullPointerException();
        }
        StringBuilder sb = new StringBuilder(newStringLen);
        int i = 0;
        do {
            sb.append(originString, i, j).append(replace);
            i = j + tarLen;
        } while (j < oriLen && (j = originString.indexOf(target, j + tarLen)) > 0);
        return sb.append(originString, i, oriLen).toString();
    }

}
