package com.xxx.leetcode.top100;

/**
 * @description: https://leetcode.cn/problems/first-missing-positive/
 * @author: liujiabing
 * @create: 2023-05-28 08:46
 **/

public class _41_缺失的第一个正数 {


    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while(nums[i]>0&&nums[i]<=len&&nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < len; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }

    private void swap(int[]arr,int a,int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}