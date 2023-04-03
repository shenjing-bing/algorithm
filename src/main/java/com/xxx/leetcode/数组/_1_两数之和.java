package com.xxx.leetcode.数组;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/two-sum/">...</a>
 * @author shenjingbin
 */
public class _1_两数之和 {

    //哈希映射,一次遍历判断target-nums[i]在map中是否存在，存在直接返回即可，不存在将当前nums[i]放入到map中
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target-nums[i];
           if (map.containsKey(temp)){
              return new int[]{i,map.get(temp)};
           }
            map.put(nums[i],i);
        }
        throw new RuntimeException("not found target number");
    }
    //暴力破解法，两次for循环
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("not found target number");
    }

}
