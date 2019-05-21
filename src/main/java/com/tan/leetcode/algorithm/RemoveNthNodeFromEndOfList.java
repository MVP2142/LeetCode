package com.tan.leetcode.algorithm;

/**
 * Create by zhuojun.tian
 * on 2019/5/9
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        for (int i = 1; i < 7; i++) {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(3);
            ListNode n4 = new ListNode(4);
            ListNode n5 = new ListNode(5);
            ListNode n6 = new ListNode(6);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            n5.next = n6;
            ListNode head = removeNthFromEnd(n1, i);
            while (head != null) {
                System.out.print(head.val + "→");
                head = head.next;
            }
            System.out.print("\n");
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

}
