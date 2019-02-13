package com.tan.leetcode.algorithm;

/**
 * Create by zhuojun.tian
 * on 2019/2/13
 * <p>
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l1.next == null) {
            return l2;
        }
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }
        int n = l1.val + l2.val;
        int c = n / 10;
        ListNode result, temp = result = new ListNode(n % 10);
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            n = l1.val + l2.val;
            temp = temp.next = new ListNode((n + c) % 10);
            c = (n + c) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            n = l1.val;
            temp = temp.next = new ListNode((n + c) % 10);
            c = (n + c) / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            n = l2.val;
            temp = temp.next = new ListNode((n + c) % 10);
            c = (n + c) / 10;
            l2 = l2.next;
        }
        if (c != 0) {
            temp.next = new ListNode(c);
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
