package com.xjtu.interview.huawei;

import java.util.Stack;


/*
 * 逻辑计算器
 *
 *
 * */
public class LogicCalculator {
    public static void main(String[] args) {

        System.out.println(testWithBrackets("1|(1&0)"));
        System.out.println(testWithBrackets("1&0|0&1"));
        System.out.println(testWithBrackets("!0&1|0"));
        System.out.println(testWithBrackets("((!0&1))|0"));
        System.out.println(testWithBrackets("!(1&0)|0&1"));
    }

    //!运算符
    private static int Not(int a) {
        if (a == 1) {
            return 0;
        }
        return 1;
    }

    //&运算符
    private static int And(int a, int b) {
        return a & b;
    }

    //|运算符
    private static int Or(int a, int b) {
        return a | b;
    }

    //运算
    private static int testWithBrackets(String str) {
        Stack<Character> characterStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        char[] a = str.toCharArray();
        //用于判断冗余的括号
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                count++;
            } else if (a[i] == '1' || a[i] == '0') {
                numberStack.push(Integer.parseInt("" + a[i]));
            } else if (a[i] == '&' || a[i] == '|' || a[i] == '!') {
                characterStack.push(a[i]);
            } else if (a[i] == ')' & --count > 0) {
                if (characterStack.size() != 0 & numberStack.size() != 0) {
                    char tempChar = characterStack.pop();
                    int tempInt = numberStack.pop();
                    if (tempChar == '&') {
                        tempInt = tempInt & numberStack.pop();
                    } else if (tempChar == '|') {
                        tempInt = tempInt | numberStack.pop();
                    } else if (tempChar == '!') {
                        tempInt = Not(tempInt);
                    }
                    numberStack.push(tempInt);
                }

            }

        }
        if (characterStack.size() != 0) {
            while (characterStack.size() != 0) {
                if (characterStack.peek() == '&') {
                    int tempInt = numberStack.pop();
                    tempInt = And(numberStack.pop(), tempInt);
                    numberStack.push(tempInt);
                    characterStack.pop();
                } else if (characterStack.peek() == '|') {
                    int tempInt = numberStack.pop();
                    tempInt = Or(numberStack.pop(), tempInt);
                    numberStack.push(tempInt);
                    characterStack.pop();
                } else if (characterStack.peek() == '!') {
                    int tempInt = numberStack.pop();
                    tempInt = Not(tempInt);
                    numberStack.push(tempInt);
                    characterStack.pop();
                }
            }
        }
        return numberStack.pop();
    }




    /*//a优先级高于b 返回true a优先级小与b 返回false
    public static boolean compareChar(char a, char b) {
        if (a == '!' & (b == '&' | b == '|')) {
            return true;
        } else if (a == '&' & b == '|') {
            return true;
        }
        //一会考虑a == b 的情况
        return false;
    }*/

   /* public static int testWithoutBrackets(String str) {
        Stack<Character> characterStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '1' || a[i] == '0') {
                numberStack.push(Integer.parseInt("" + a[i]));
            } else if (a[i] == '&' || a[i] == '|' || a[i] == '!') {
                if (characterStack == null) {
                    characterStack.push(a[i]);
                } else {
                    if (compareChar(characterStack.peek(), a[i])) {
                        if (characterStack.peek() == '!') {
                            numberStack.push(not(numberStack.pop()));
                            characterStack.push(a[i]);
                        } else if (characterStack.peek() == '&') {
                            int tempInt = numberStack.pop();
                            tempInt = tempInt & numberStack.pop();
                            numberStack.push(tempInt);
                        } else if (characterStack.peek() == '|') {
                            int tempInt = numberStack.pop();
                            tempInt = tempInt | numberStack.pop();
                            numberStack.push(tempInt);
                        }
                    }
                }
            }
            if (characterStack.pop() == '&') {
                int tempInt = numberStack.pop();
                tempInt = tempInt & numberStack.pop();
                numberStack.push(tempInt);
            } else if (characterStack.pop() == '|') {
                int tempInt = numberStack.pop();
                tempInt = tempInt | numberStack.pop();
                numberStack.push(tempInt);
            }
        }
        return numberStack.pop();
    }*/
}

