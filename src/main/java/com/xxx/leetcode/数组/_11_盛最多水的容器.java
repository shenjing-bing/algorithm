package com.xxx.leetcode.数组;

/**
 * @description:
 * @author: liujiabing
 * @create: 2023-03-21 14:38
 **/

public class _11_盛最多水的容器 {

    /**
     * 暴力解法，双重for循环
     * 
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }

    /**
     * 双指针，首先定义头部和尾部两个指针，此时指针的宽度已经是最大了，然后向中间缩小，每次缩小都是从低的那头开始缩，然后记录当前缩小后的面积，与当前的最大面积做比较
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = height[i] < height[j] ? Math.max(maxArea, (j - i) * height[i++])
                : Math.max(maxArea, (j - i) * height[j--]);
        }
        return maxArea;
    }
}