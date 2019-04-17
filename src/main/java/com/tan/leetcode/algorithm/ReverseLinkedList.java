package com.tan.leetcode.algorithm;

/**
 * Create by zhuojun.tian
 * on 2019/4/18
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = reverseList1(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    //普通循环
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp;
        ListNode newHead = null;
        while (head.next != null) {
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        head.next = newHead;
        return head;
    }

    //普通循环-使用哨兵简化代码
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp;
        ListNode newHead = new ListNode(0);
        while (head != null) {
            temp = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = temp;
        }
        return newHead.next;
    }

    //递归
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList3(next);
        head.next = null;
        next.next = head;
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}


