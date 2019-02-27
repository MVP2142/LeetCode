package com.tan.leetcode.algorithm;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 * Create by zhuojun.tian
 * on 2019/2/23
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int origin = x;
        int reverse = 0;
        while (origin > 0) {
            reverse = reverse * 10 + origin % 10;
            origin /= 10;
        }
        return x == reverse;
    }

    public static boolean isPalindrome2(int x) {
        //optimizations
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        if (x < 100 && x % 11 == 0) {
            return true;
        }
        if (x < 1000 && ((x / 100) * 10 + x % 10) % 11 == 0) {
            return true;
        }

        int v = x % 10;
        x = x / 10;
        while (x - v > 0) {
            v = v * 10 + x % 10;
            x /= 10;
        }
        if (v > x) {
            v /= 10;
        }
        return v == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

}
