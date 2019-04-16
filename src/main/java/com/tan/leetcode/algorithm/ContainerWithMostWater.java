package com.tan.leetcode.algorithm;

/**
 * Create by zhuojun.tian
 * on 2019/2/23
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max = 0;
        int k = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                k = Math.min(height[i], height[j]) * (j - i);
                if (max < k) {
                    max = k;
                }
            }
        }
        return max;
    }

    public static int maxArea2(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
