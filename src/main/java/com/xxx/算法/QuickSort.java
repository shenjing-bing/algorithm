package com.xxx.算法;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: 快速排序
 * @author: liujiabing
 * @create: 2023-04-03 17:04
 **/
@Slf4j
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 8, 2, 3, 9};
        log.info(Arrays.toString(quickSort(arr)));
    }

    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int[] quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return arr;
        }
        int pivotIndex = partition(arr, begin, end);
        quickSort(arr, begin, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
        return arr;
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivotValue = arr[begin];
        int i = begin;
        while (begin < end) {
            while (begin < end && arr[end] >= pivotValue) {
                end--;
            }
            while (begin < end && arr[begin] <= pivotValue) {
                begin++;
            }
            if (begin < end) {
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
            }
        }
        arr[i] = arr[begin];
        arr[begin] = pivotValue;
        return begin;
    }

}