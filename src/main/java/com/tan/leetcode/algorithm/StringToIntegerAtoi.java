package com.tan.leetcode.algorithm;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character
 * is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and
 * have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1)
 * or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 *
 * @author zhuojun.tian
 * @since 2019/2/20
 */
public class StringToIntegerAtoi {

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] list = str.toCharArray();
        int index = 0;
        while (index < list.length && list[index] == ' ') {
            index++;
        }
        StringBuilder sb = new StringBuilder();
        int sign = 1;
        if (index < list.length && (list[index] == '+' || list[index] == '-')) {
            sign = list[index] == '+' ? 1 : -1;
            index++;
        }
        while (index < list.length && list[index] >= '0' && list[index] <= '9') {
            sb.append(list[index]);
            index++;
        }

        if (sb.length() == 0) {
            return 0;
        }
        try {
            long l = Long.parseLong(sb.toString());
            if (l * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (l * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) (l * sign);
        } catch (Exception e) {
            if (sign > 0) {
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;
        }
    }

    public static int myAtoi2(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int index = 0;
        int result = 0;
        int sign = 1;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            if (sign > 0 && (result > Integer.MAX_VALUE / 10 || (result ==
                    Integer.MAX_VALUE / 10 && str.charAt(index) > '7'))) {
                return Integer.MAX_VALUE;
            }
            if (sign < 0 && (result > Integer.MAX_VALUE / 10 || (result ==
                    Integer.MAX_VALUE / 10 && str.charAt(index) > '8'))) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + str.charAt(index++) - '0';
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi2("42"));
    }
}











