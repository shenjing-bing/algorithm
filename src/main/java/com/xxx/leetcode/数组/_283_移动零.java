package com.xxx.leetcode.数组;

/**
 * @description:
 * @author: liujiabing
 * @create: 2023-03-20 20:53
 **/

public class _283_移动零 {
    /**
     *  第一轮遍历j用来记录当前数组中0的个数，同时遇到非0的数就与当前j做交换
     *  第二轮遍历将数组的后j位置为0
     * @param nums 原数组
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[j++] = num;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i]=0;
        }
    }

    /**
     * 循环不变量：在每一次循环前，j 的左边全部都是不等于0的
     * 起始j为0，明显满足
     * 此后每一次循环中，若nums[i] = 0，则j保持不变，满足；若nums[i] != 0，交换后j增一，仍然满足
     * @param nums 原数组
     */
    public void moveZeroes1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }

    }
}