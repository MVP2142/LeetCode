package com.tan.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @author zhuojun.tian
 * @since 2019/2/26
 */
public class TwoSum {
    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    //进行了重排序，还要另外记录原来的index值，不如解法1
    // public static int[] twoSum2(int[] nums, int target) {
    //     if (nums == null || nums.length < 2) {
    //         return null;
    //     }
    //     Arrays.sort(nums);
    //     int l = 0, r = nums.length - 1;
    //     while (l < r) {
    //         if (nums[l] + nums[r] < target) {
    //             l++;
    //             continue;
    //         }
    //         if (nums[l] + nums[r] > target) {
    //             r--;
    //             continue;
    //         }
    //         if (nums[l] + nums[r] == target) {
    //             return new int[]{l, r};
    //         }
    //     }
    //     return null;
    // }

    public static void main(String[] args) {
        System.out.println(twoSum1(new int[]{3, 2, 4}, 6));
    }
}
