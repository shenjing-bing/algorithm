package com.xxx.huawei;

import java.util.Scanner;

/**
 * @description: 字符串最后一个单词的长度
 * @author: liujiabing
 * @create: 2023-05-21 08:44
 **/

public class HJ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        System.out.println(strArr[strArr.length-1].length());
    }
}