package com.xxx.huawei;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @description: 合并表记录
 * @author: liujiabing
 * @create: 2023-05-22 20:38
 **/

public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if(!map.containsKey(key)){
                map.put(key,value);
                continue;
            }
            map.put(key,map.get(key)+value);
        }
        map.entrySet().stream().forEach(t->{
            System.out.println(t.getKey()+" "+t.getValue());
        });
    }
}