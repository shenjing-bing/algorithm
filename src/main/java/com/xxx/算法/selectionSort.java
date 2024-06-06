package com.xxx.算法;

import java.util.Arrays;

/**
 * @author shenjingbin
 * @date 2021/11/2
 */

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 2, 6, 7, 8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    //选择排序的思想 ，通过每轮通过两两比较记录下最小值，在每轮结束之后，将最小值所在的下标与当前比较的其实位置进行交换
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
