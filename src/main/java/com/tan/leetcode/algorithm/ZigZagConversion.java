package com.tan.leetcode.algorithm;

/**
 * @author zhuojun.tian
 * @since 2019/2/21
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (s == null) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int i = 0, j, gap = numRows - 2, size = s.length();
        while (i < size) {
            for (j = 0; i < size && j < numRows; j++) {
                sbs[j].append(s.charAt(i++));
            }
            for (j = gap; i < size && j > 0; j--) {
                sbs[j].append(s.charAt(i++));
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbs) {
            result.append(sb.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAHNAPLSIIGYIR", 3));
    }
}
