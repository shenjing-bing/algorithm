package com.xxx.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @description: 提取不重复的整数
 * @author: liujiabing
 * @create: 2023-05-22 20:57
 **/

public class HJ9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while (num!=0) {
            if(set.add(num%10)){
                sum=sum*10+num%10;
            }
            num/=10;
        }
        System.out.println(sum);
    }
}