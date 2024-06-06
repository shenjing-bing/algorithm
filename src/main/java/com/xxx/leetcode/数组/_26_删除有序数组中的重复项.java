package com.xxx.leetcode.数组;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">...</a>
 * 
 * @description: 删除有序数组中的重复项
 * @author: liujiabing
 * @create: 2023-03-15 17:08
 **/
@Slf4j
public class _26_删除有序数组中的重复项 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3};
        log.info("新数组长度" + removeDuplicates(arr));
        log.info(Arrays.toString(arr));
    }

    /**
     * 双指针方法,因为数组相对有序,那么重复的元素一定会相邻,定义前后两个指针,p,q，每次比较两个指针上的值， 如果相等则q++; 如果不相等，则将当前q位置上的值与p+1上的值做交换，然后p++，q++;
     * 
     * @param nums 源数组
     * @return 新数组长度
     */
    public static int removeDuplicates(int[] nums) {
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[q] != nums[p]) {
                if (q - p > 1) {
                    nums[++p] = nums[q];
                }
            }
            q++;
        }
        return p + 1;
    }

    /**
     * 通用解法 ,「最多保留 1 位」修改为「最多保留 k 位」。 1:对于前k个数字可以直接保留进入目标数组， 2:对于后面的任意数字，能不能进入目标数组的前提是，如果当前数字与原数组的前k位的数字不想等，则进入目标数组
     * 
     * @param nums 源数组
     * @return 新数组长度
     */
    public static int removeDuplicates(int[] nums, int k) {
        int idx = 0;
        for (int num : nums) {
            if (idx < k || nums[idx - k] != num) {
                nums[idx++] = num;
            }
        }
        return idx;
    }

    /**
     * 通用解法+剪枝，利用目标数组的最后一个元素必然与原数组的最后一个元素相同进行剪枝，从而确保当数组有超过 k 个最大值时，数组不会被完整扫描
     * 
     * @param nums 源数组
     * @return 新数组长度
     */
    public static int removeDuplicates(int[] nums, int k, int max) {
        int idx = 0;
        for (int num : nums) {
            if (idx < k || nums[idx - k] != num) {
                nums[idx++] = num;
            }
            if (idx - k >= 0 && nums[idx - k] == max) {
                break;
            }
        }
        return idx;
    }
}