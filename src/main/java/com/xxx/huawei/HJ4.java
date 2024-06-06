package com.xxx.huawei;

import java.util.Scanner;

/**
 * @description: 字符串分隔
 * @author: liujiabing
 * @create: 2023-05-21 10:13
 **/

public class HJ4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int a = s.length() / 8;
        int b = s.length() % 8;
        for (int i = 0; i < a; i++) {
            System.out.println(s.substring(i * 8, (i + 1) * 8));
        }
        if (b != 0) {
            String substring = s.substring(a * 8, s.length());
            StringBuilder stringBuffer = new StringBuilder(substring);
            for (int i1 = 0; i1 < 8 - b; i1++) {
                stringBuffer.append("0");
            }
            System.out.println(stringBuffer.toString());
        }
    }
}