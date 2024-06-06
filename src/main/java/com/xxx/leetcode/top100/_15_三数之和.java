package com.xxx.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: liujiabing
 * @create: 2023-03-21 18:29
 **/
@Slf4j
public class _15_三数之和 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        log.info(threeSum(arr).toString());
        log.info(threeSum1(arr).toString());
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int targetIndex = 0;
        while (targetIndex<nums.length-2){
            if(nums[targetIndex]>0){
                return lists;
            }
            int begin = targetIndex+1;
            int end = nums.length - 1;
            while(begin<end){
                int sum = nums[targetIndex]+nums[begin]+nums[end];
                if(sum==0){
                    lists.add(Arrays.asList(nums[targetIndex],nums[begin],nums[end]));
                }
                if(sum<=0){
                    while(nums[begin++]==nums[begin]&&begin<end){

                    }
                }
                if(sum>=0){
                    while(nums[end--]==nums[end]&&begin<end){

                    }
                }
            }
            while (nums[targetIndex] == nums[++targetIndex] && targetIndex < nums.length - 2) {

            }
        }
        return lists;
    }












    /**
     * 暴力先对数组排序，然后采用三层for循环的方式找出，找出所有可能， 需要注意，排完序的数组中有可能有重复元素，此时需要在每层遍历时，判断如果当前元素，与上一次的元素想等，则说明这个元素，在上一次已经被处理过，直接跳过
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
                    if (nums[i] + nums[j] + nums[z]==0) {
                        arrayList.add(Arrays.asList(nums[i], nums[j], nums[z]));
                    }
                }
            }
        }
        return arrayList;
    }

    /**
     * 双指针 优化 先对数组排序 定义初始下标i 为排序后数组的开始，采用头尾指针的方式，头指针为i+1，尾指针为nums.length - 1 判断三数之和
     * 如果等于0直接放到结果list中，因为数组中可能存在重复值，所以直接将头指针向后移动到下一个不想等的值上，尾指针同理 当前下标比较完后，将当前下表移动到下一个不行等的值上
     * 
     * 
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) {
                break;
            }
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int sum = nums[i] +nums[begin]+nums[end];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[begin], nums[end]));
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
        return list;
    }
}