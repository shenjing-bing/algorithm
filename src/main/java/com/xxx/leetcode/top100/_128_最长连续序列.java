package com.xxx.leetcode.top100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @description: https://leetcode.cn/problems/longest-consecutive-sequence/
 * @author: liujiabing
 * @create: 2023-05-23 10:29
 **/

public class _128_最长连续序列 {

    public int longestConsecutive1(int[] nums) {
        Set<Integer> set =Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLength = 0;
        for (int num : nums) {
            int temp = 1;
            if (set.contains(num-1)){
                continue;
            }
            while (set.contains(num++)){
                temp++;
            }
            maxLength = Math.max(maxLength, temp);
        }
        return maxLength;

    }








    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        int maxLength = 0;
        for (int num : nums) {
            int currentLength = 0;
            if (!set.contains(num-1)){
                while(set.contains(num++)){
                    currentLength++;
                }
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}