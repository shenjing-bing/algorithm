package com.xxx.算法;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shenjingbin
 * @date 2021/11/2
 */
@Slf4j
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 7, 12, 3, 9};
        log.info(Arrays.toString(bubbleSortArr(arr)));
    }

    // 冒泡排序的思想，通过从前向后两两比较，将较大的元素放在最后面
    public static int[] bubbleSortArr(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            boolean flag = false;
            for (int begin = 0; begin < end; begin++) {
                if (arr[begin] > arr[begin + 1]) {
                    int temp = arr[begin];
                    arr[begin] = arr[begin + 1];
                    arr[begin + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }
}
