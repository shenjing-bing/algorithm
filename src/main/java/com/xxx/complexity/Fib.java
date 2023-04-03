package com.study.fib;

/**
 * @author shenjingbin
 * @date 2021/9/18
 */
public class Fib {


    public int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //优化
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        while (n-- > 1) {
            second += first;
            first = second - first;
        }
        return second;
    }

    //线性代数解法
    public int fib3(int n) {
        double c = Math.sqrt(5);
        return (int) ((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        long l1 = System.currentTimeMillis();
        System.out.println(fib.fib3(30));
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        System.out.println(fib.fib2(30));
        long l3 = System.currentTimeMillis();
        System.out.println(l3 - l2);
    }
}
