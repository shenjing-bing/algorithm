package com.xxx.leetcode.top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode.cn/problems/sliding-window-maximum/
 * @author: liujiabing
 * @create: 2023-05-26 06:10
 **/

public class _239_滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null||nums.length<k) {
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        result[0]=nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            //向左移动一位移动窗口
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            //向右移动一位窗口
            if (deque.peekFirst()==i-k){
                deque.pollFirst();
            }
            result[i-k+1]=nums[deque.peekFirst()];
        }
        return result;
    }
}