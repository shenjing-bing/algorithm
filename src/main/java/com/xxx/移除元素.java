package com.xxx;

import java.util.Arrays;

public class 移除元素 {
    public static void main(String[] args) {
        int nums[] = {3,2,2,3};
        System.out.println(removeElement(nums,3));
    }
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right--];
            }else{
                left++;
            }
        }
        return right+1;
    }
}
