package com.xxx.leetcode.top100;

import java.util.HashMap;

/**
 * @description: https://leetcode.cn/problems/subarray-sum-equals-k/
 * @author: liujiabing
 * @create: 2023-05-24 23:17
 **/

public class _560_和为K的子数组 {

    public static void main(String[] args) {
        int[] arr = {1};
        int k = 0;
        subarraySum(arr,k);
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(nums[i] - k)) {
                count += map.get(nums[i] - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}