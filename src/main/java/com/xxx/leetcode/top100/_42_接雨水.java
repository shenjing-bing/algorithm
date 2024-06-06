package com.xxx.leetcode.top100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: https://leetcode.cn/problems/trapping-rain-water/
 * @author: liujiabing
 * @create: 2023-05-23 21:15
 **/

public class _42_接雨水 {

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(arr));
    }
    public static int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int width = i-left-1;
                int h = Math.min(height[left],height[i])-height[top];
                sum+=width*h;
            }
            stack.push(i);
        }
        return sum;
    }



    public int trap1(int[] height) {
        int asInt = Arrays.stream(height).max().getAsInt();
        int area = 0;
        for (int i = 1; i <=asInt; i++) {
            boolean flag =false;
            int tempArea = 0;
            for (int j = 0; j < height.length; j++) {
                if(height[j]>=i){
                    area += tempArea;
                    tempArea=0;
                    flag = true;
                }
                if(height[j]<i&&flag){
                    tempArea++;
                }
            }
        }
        return area;
    }

    public static int trap2(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight= new int[height.length];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i]=Math.max(maxLeft[i-1],height[i-1]);
        }
        for (int i = height.length-2; i >=0; i--) {
            maxRight[i]=Math.max(maxRight[i+1],height[i+1]);
        }
        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(maxRight));
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min>height[i]){
                sum+=min-height[i];
            }
        }
        return sum;
    }


}