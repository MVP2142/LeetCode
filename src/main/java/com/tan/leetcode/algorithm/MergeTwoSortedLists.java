package com.tan.leetcode.algorithm;

/**
 * Create by zhuojun.tian
 * on 2019/4/18
 */
public class MergeTwoSortedLists {

    public static ListNode head;
    public static ListNode tail;

    public static void add(ListNode next) {
        if (head == null) {
            head = tail = next;
        } else {
            tail.next = next;
            tail = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node3.next = node4;
        ListNode result = mergeTwoLists(node1, node3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        head = tail = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                add(l1);
                l1 = l1.next;
            } else {
                add(l2);
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            add(l1);
        } else if (l2 != null) {
            add(l2);
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
