package com.xxx.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @description: 明明的随机数
 * @author: liujiabing
 * @create: 2023-05-21 08:47
 **/

public class HJ3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i1 = 0; i1 < i; i1++) {
            treeSet.add(scanner.nextInt());
        }
        treeSet.stream().forEach(num-> System.out.println(num));


    }
}