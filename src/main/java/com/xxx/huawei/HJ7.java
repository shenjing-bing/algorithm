package com.xxx.huawei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @description: 取近似值
 * @author: liujiabing
 * @create: 2023-05-22 20:31
 **/

public class HJ7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double v = scanner.nextDouble();
        BigDecimal add = BigDecimal.valueOf(v).add(BigDecimal.valueOf(0.5));
        int i = add.intValue();
        System.out.println(i);
    }
}