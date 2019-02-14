package com.tan.leetcode.algorithm;

import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Create by zhuojun.tian
 * on 2019/2/14
 */
public class LongestSubstringWithoutRepatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        int walker = 0;
        int runner = 0;
        while (runner < s.length()) {
            if (set.contains(s.charAt(runner))) {
                if (max < runner - walker) {
                    max = runner - walker;
                }
                while (s.charAt(walker) != s.charAt(runner)) {
                    set.remove(s.charAt(walker));
                    walker++;
                }
                walker++;
            } else {
                set.add(s.charAt(runner));
            }
            runner++;
        }
        max = Math.max(max, runner - walker);
        return max;
    }

}
