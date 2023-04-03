package com.xxx.leetcode.数组;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: liujiabing
 * @create: 2023-03-20 21:38
 **/

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 8, 4, 6, 1, 3, 12, 10};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] nums) {
        quickSort(nums,0,nums.length);
    }

    private static void quickSort(int[] nums, int begin, int end) {
        if (end-begin <= 1) {
            return;
        }
        int pivot = getPivot(nums, begin, end);
        quickSort(nums, begin, pivot);
        quickSort(nums, pivot+1, end);
    }

    private static int getPivot(int[] nums, int begin, int end) {
        int pivotNum = nums[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                if (nums[end] > pivotNum) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                    break;
                }
            }
            while (begin < end) {
                if (nums[begin] < pivotNum) {
                    begin++;
                } else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }
        nums[begin]=pivotNum;
        return begin;
    }

}