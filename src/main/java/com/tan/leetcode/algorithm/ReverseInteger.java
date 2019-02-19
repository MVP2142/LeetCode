package com.tan.leetcode.algorithm;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your
 * function returns 0 when the reversed integer overflows.
 *
 * @author zhuojun.tian
 * @since 2019/2/19
 */
public class ReverseInteger {

    public static int reverse(int x) {
        try {
            int negative = 1;
            if (x < 0) {
                negative = -1;
                x = -x;
            }
            char[] digits = String.valueOf(x).toCharArray();
            int i = digits.length - 1;
            for (; i >= 0; i--) {
                if (digits[i] != 0) {
                    break;
                }
            }
            char[] reverseDigits = new char[i + 1];
            for (; i >= 0; i--) {
                reverseDigits[reverseDigits.length - 1 - i] = digits[i];
            }
            return Integer.parseInt(String.valueOf(reverseDigits)) * negative;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int reverse2(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println("123:\t" + reverse(123));
        System.out.println("-123:\t" + reverse(-123));
    }

}
