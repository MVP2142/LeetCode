package com.tan.leetcode.algorithm;

/**
 * Create by zhuojun.tian
 * on 2019/5/21
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode result = swapPairs(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode last = result;
        ListNode temp;
        while (last.next != null && last.next.next != null) {
            temp = last.next.next;
            last.next.next = temp.next;
            temp.next = last.next;
            last.next = temp;
            last = last.next.next;
        }
        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
