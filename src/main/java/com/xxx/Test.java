package com.xxx;

import java.util.HashMap;

/**
 * @description:
 * @author: liujiabing
 * @create: 2023-05-06 09:40
 **/

public class Test {
    public static void main(String[] args) {
        int[] arr = {4,5,5,1,2};
        sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
           if (!map.containsKey(arr[i])){
               map.put(arr[i],1);
               continue;
           }
           map.put(arr[i],map.get(arr[i])+1);
        }
        System.out.println(arr[arr.length-map.get(arr[arr.length-1])-1]);

    }
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j =0 ; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }



}