package com.xxx.leetcode.top100;

import java.util.Arrays;

/**
 * @description: https://leetcode.cn/problems/product-of-array-except-self/
 * @author: liujiabing
 * @create: 2023-05-28 07:57
 **/

public class _238_除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        productExceptSelf(arr);
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            suffix = suffix*nums[j+1];
            answer[j] = suffix*answer[j];
        }
        return answer;
    }
    public static int[] productExceptSelf1(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        System.out.println(Arrays.toString(prefix));
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            suffix[j] = suffix[j+1] * nums[j+1];
        }
        System.out.println(Arrays.toString(suffix));
        int[] answer = new int[nums.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = prefix[i] * suffix[i];
        }
        return answer;
    }
}