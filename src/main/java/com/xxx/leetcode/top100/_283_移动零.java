package com.xxx.leetcode.top100;

/**
 * @description: https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
 * @author: liujiabing
 * @create: 2023-05-23 10:56
 **/

public class _283_移动零 {



    public void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                if(i!=j){
                    nums[j]=nums[i];
                    nums[i]=0;
                }
                j++;
            }
        }
    }







    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}