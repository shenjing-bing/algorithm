package com.xxx.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @description: 字符个数统计
 * @author: liujiabing
 * @create: 2023-05-22 21:06
 **/

public class HJ10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch<=127) {
                set.add(ch);
            }
        }
        System.out.println(set.size());
    }
}