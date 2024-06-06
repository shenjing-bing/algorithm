package com.xxx.huawei;

import java.util.Scanner;

/**
 * @description: 质数因子
 * @author: liujiabing
 * @create: 2023-05-22 20:20
 **/

public class HJ6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long k = (long) Math.sqrt(l);
        for (long i = 2; i <=k; i++) {
            while(l%i==0){
                System.out.print(i+" ");
                l/=i;
            }
        }
        System.out.println(l == 1 ? "" : l+" ");
    }
}