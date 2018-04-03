package com.example.shuati.niukewang.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class T3 {

    //输入一个链表，从尾到头打印链表每个节点的值。

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> temp = new Stack<Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        ListNode t = listNode;
        while (t != null) {
            temp.push(t.val);
            t = t.next;
        }
        while (!temp.empty()) {
            newList.add(temp.pop());
        }
        return newList;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ArrayList<Integer> list = printListFromTailToHead(l1);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
