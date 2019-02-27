package com.tan.leetcode.algorithm;

/**
 * @author zhuojun.tian
 * @since 2019/2/25
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int minLength = minLength(strs);
        for (int i = 0; i < minLength; i++) {
            if (theSame(strs, i)) {
                result.append(strs[0].charAt(i));
            } else {
                return result.toString();
            }
        }
        return result.toString();
    }

    private static int minLength(String[] strs) {
        int n = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            n = n < strs[i].length() ? n : strs[i].length();
        }
        return n;
    }

    private static boolean theSame(String[] strs, int k) {
        char c = strs[0].charAt(k);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(k) != c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"1flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
