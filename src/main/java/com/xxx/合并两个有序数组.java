package com.xxx;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ints = new int[m + n];
        int x = 0;
        int y = 0;
        int cur = 0;
        while (x < m || y < n) {
            if (x == m) {
                cur = nums2[y++];
            } else if (y == n) {
                cur = nums1[x++];
            } else if (nums1[x] <= nums2[y]) {
                cur = nums1[x++];
            } else {
                cur = nums2[y++];
            }
            ints[x + y - 1] = cur;
        }
        Arrays.stream(ints).forEach(t->System.out.println(t));
        nums1 = ints;
        Arrays.stream(nums1).forEach(t->System.out.println(t));
    }

}
