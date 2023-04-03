package com.xxx.leetcode.其它;

/**
 * @description:
 * @author: liujiabing
 * @create: 2023-03-21 15:05
 **/

public class _70_爬楼梯 {
    /**
     * 递归解法 当只有一层楼梯时 我们只有 1 一种走法 当有两层楼梯时，我们有1+1 或者 2两种走法 当有三层楼梯时，我们走法 一层楼梯的走法+2 + 两层楼梯的走法+1 = 一层楼梯的走法+两层楼梯的走法
     * 
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }

}