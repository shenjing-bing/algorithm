package com.xxx.leetcode.top100;

/**
 * @description: https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked
 * @author: liujiabing
 * @create: 2023-05-23 11:14
 **/

public class _11_盛最多水的容器 {

    public int maxArea1(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while (left<right){
            maxArea =    height[left]<height[right]?
                    Math.max(maxArea,(right-left)*height[left++])
                    :Math.max(maxArea,(right-left)*height[right--]);
        }
        return 0;
    }





















    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length;
        int maxArea = 0;
        while (i < j) {
            maxArea = height[i] < height[j] ? Math.max(maxArea, (j - i) * height[i++])
                : Math.max(maxArea, (j - i) * height[j--]);
        }

        return maxArea;
    }
}