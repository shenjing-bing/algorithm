package com.xxx.算法;

/**
 * @description: 斐波那契数
 * @author: liujiabing
 * @create: 2023-02-23 08:32
 **/

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(getFibonacciNumberForCycle(44));
    }

    /**
     * 递归的方式解决
     * @param n 斐波那契数的第几个数
     * @return Integer 第n个斐波那契数
     */
    public static Integer getFibonacciNumberForRecurve(int n) {
        if (n <= 1) {
            return n;
        }
        return getFibonacciNumberForRecurve(n - 1) + getFibonacciNumberForRecurve(n - 2);
    }
    /**
     * for循环方式解决利用的思想是计算直接从头开始算，每次将第二个数作为后一次算的第一个数，将第一次算出的结果作为后一次要算的第二个数
     * @param n 斐波那契数的第几个数
     * @return Integer 第n个斐波那契数
     */
    public static Integer getFibonacciNumberForCycle(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        int i = 0;
        while (i < n-1) {
            int sum = first + second;
            first = second;
            second = sum;
            i++;
        }
        return second;
    }
}