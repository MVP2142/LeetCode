package com.tan.leetcode.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Create by zhuojun.tian
 * on 2019/2/13
 */
class AddTwoNumbersTest {

    static AddTwoNumbers addTwoNumbers;

    @BeforeAll
    public static void before() {
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    public void test1() {
        AddTwoNumbers.ListNode l1 = addTwoNumbers.new ListNode(0);
        AddTwoNumbers.ListNode l2 = addTwoNumbers.new ListNode(1);
        AddTwoNumbers.ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(l2, result);

        l1 = addTwoNumbers.new ListNode(0);
        l2 = addTwoNumbers.new ListNode(0);
        result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(l2, result);

        l1 = addTwoNumbers.new ListNode(1);
        l2 = addTwoNumbers.new ListNode(0);
        result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(l1, result);
    }

    @Test
    public void test2() {
        AddTwoNumbers.ListNode l1 = addTwoNumbers.new ListNode(1);
        l1.next = addTwoNumbers.new ListNode(9);
        l1.next.next = addTwoNumbers.new ListNode(1);
        AddTwoNumbers.ListNode l2 = addTwoNumbers.new ListNode(9);
        AddTwoNumbers.ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(0, result.val);
        result = result.next;
        assertEquals(0, result.val);
        result = result.next;
        assertEquals(2, result.val);
    }

    @Test
    public void test3() {
        AddTwoNumbers.ListNode l1 = addTwoNumbers.new ListNode(1);
        AddTwoNumbers.ListNode l2 = addTwoNumbers.new ListNode(9);
        l2.next = addTwoNumbers.new ListNode(9);
        l2.next.next = addTwoNumbers.new ListNode(1);
        AddTwoNumbers.ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(0, result.val);
        result = result.next;
        assertEquals(0, result.val);
        result = result.next;
        assertEquals(2, result.val);
    }

}