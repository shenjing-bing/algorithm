package com.xxx.leetcode;

import java.util.Scanner;

/**
 * @description:
 * @author: liujiabing
 * @create: 2023-05-31 13:05
 **/

public class Test {


    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int left = 0;
        int right = 1;
        int count = 0;
        while(right<str.length()){
            String substring = str.substring(left, right);
            if (!check(substring)){
                right++;
                count++;
                continue;
            }else{
                left=right;
                right++;
            }

        }


        boolean check = check("AX");
        System.out.println(check);
    }
    private static boolean check(String str){
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum+=str.charAt(i);
        }
        System.out.println(sum);
        int sum2= 0;
        int sum3= sum;
        while(sum!=0){
            int i = sum%10;
            sum2+=i*i*i;
            sum=sum/10;
            System.out.println(sum);
            System.out.println(sum2);
        }
        return sum3==sum2;
    }
}