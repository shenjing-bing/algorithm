package com.xxx.leetcode.top100;

/**
 * @description: https://leetcode.cn/problems/maximum-subarray/
 * @author: liujiabing
 * @create: 2023-05-27 05:06
 **/

public class _53_最大子数组和 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1]<=0){
                dp[i]=nums[i];
            }else{
                dp[i]=dp[i-1]+nums[i];
            }
        }
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}