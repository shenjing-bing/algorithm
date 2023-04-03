package com.xxx.leetcode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: liujiabing
 * @create: 2023-03-21 18:29
 **/

public class _15_三数之和 {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        threeSum1(arr);
    }

    /**
     * 暴力先对数组排序，然后采用三层for循环的方式找出，找出所有可能， 需要注意，排完序的数组中有可能有重复元素，此时需要在每层遍历时，判断如果当前元素，与上一次的元素想等，则说明这个元素，在上一次
     * 
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int z = j + 1; z < nums.length; z++) {
                    if (z != j + 1 && nums[z] == nums[z - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] == nums[z]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[z]);
                        arrayList.add(list);
                    }
                }
            }
        }
        return arrayList;
    }

    /**
     * 双指针 优化
     * 
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arrayList = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                break;
            }
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    arrayList.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                }
                if (sum <= 0) {
                    while (nums[begin] == nums[++begin] && begin < end) {

                    }
                }
                if (sum >= 0) {
                    while (nums[end] == nums[--end] && begin < end) {

                    }
                }
            }
            while (nums[i] == nums[++i] && i < nums.length - 2) {

            }
        }
        return arrayList;
    }
}