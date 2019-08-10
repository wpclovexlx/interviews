package com.xjtu.pratice.SwordToOffer;

/*
 *
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 *
 * */

import java.util.ArrayList;


public class LinkedReverserToValues {
    public static void main(String[] args) {
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(7);
        first.next = second;
        second.next = third;
        ArrayList a = printListFromTailToHead(first);
        System.out.println(a);
    }

    /*//翻转ArrayList
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList();
        }
        ArrayList<Integer> arrayList = new ArrayList();
        ArrayList<Integer> arrayList1 = new ArrayList();
        ListNode p = listNode;
        while (p != null) {
            arrayList.add(p.val);
            p = p.next;
        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            arrayList1.add(arrayList.get(i));
        }
        return arrayList1;

    }*/
    //递归法
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList();

        if (listNode != null) {
            if (listNode.next != null) {
                arrayList = printListFromTailToHead(listNode.next);
            }
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


}


