package com.xxx.huawei;

import java.util.Scanner;

/**
 * @description: 进制转换
 * @author: liujiabing
 * @create: 2023-05-21 10:41
 **/

public class HJ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        baseConversion();
    }
    private static void baseConversion(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int count = 0;
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            int indexValue=0;
            if (c >= '0'&&c <= '9') {
                indexValue=c-'0';
            } else if (c>='a' && c<='f') {
                indexValue=c-'a'+10;
            }else if (c>='A' && c<='f') {
                indexValue=c-'A'+10;
            }
            count+=indexValue*Math.pow(16,s.length()-1-i);
        }
        System.out.println(count);
    }
}