package 算法;

import java.util.Arrays;

/**
 * @author shenjingbin
 * @date 2021/11/2
 */
public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 7, 12, 3, 9};
        System.out.println(Arrays.toString(bubbleSortArr(arr)));
    }

    //冒泡排序的思想，通过从前向后两两比较，将较大的元素放在最后面
    public static int[] bubbleSortArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return arr;
            }
        }
        return arr;
    }
}
