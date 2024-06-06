package com.xxx.新手班;

/**
 * @description:
 * @author: liujiabing
 * @create: 2023-07-18 23:44
 **/

public class Test {

    public static void main(String[] args) {
        System.out.println((1<<31)-1);
        System.out.println(Integer.MAX_VALUE);
    }

    public static void print(int num){
        for (int i = 31; i >=0; i--) {
            System.out.print((num&(1<<i))==0 ? 0:1);
        }
    }
}