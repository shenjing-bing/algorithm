package com.xxx.huawei;

import java.util.Scanner;

/**
 * @description: 记录某个字符出现的次数
 * @author: liujiabing
 * @create: 2023-05-21 08:53
 **/

public class HJ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        String s = input1.toLowerCase().replaceAll(input2.toLowerCase(), "");
        System.out.println(input1.length()-s.length());
    }
}