package com.tan.leetcode.algorithm;

/**
 * 160. Intersection of Two Linked Lists
 * Easy
 * <p>
 * 1968
 * <p>
 * 161
 * <p>
 * Favorite
 * <p>
 * Share
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * <p>
 * begin to intersect at node c1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * <p>
 * <p>
 * Create by zhuojun.tian
 * on 2019/4/17
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        b.next = a;
        System.out.println(getIntersectionNode(a, b).getVal());
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //任何一个链表为空都可以返回null
        if (headA == null || headB == null) {
            return null;
        }
        //记住A指针到达链表尾部的次数
        //当次数为2时，表示已到了链表B的尾部，此时还未相交就可以返回null
        int count = 0;
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            if (l1 == null) {
                count++; //到达链表末尾则计数器加1
                if (count == 2) { //两次到达链表末尾都没相交，返回null
                    return null;
                }
                l1 = headB;
            } else {
                l1 = l1.next;
            }
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
