package 数组;


import java.util.Arrays;


/**
 * @author shenjingbin
 * @date 2021/10/25
 */
public class _912_排序数组 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    // 快速排序
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (end > start) {
            int i = partition(nums, start, end);
            quickSort(nums, start, i - 1);
            quickSort(nums, i + 1, end);
        }
    }

    private static int partition(int[] nums, int start, int end) {
        System.out.println(Arrays.toString(nums));
        int pivot = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (pivot > nums[j]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        System.out.println(i);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void quickSort1(int[] nums, int start, int end) {
        if (end > start) {
            int i = partition(nums, start, end);
            quickSort(nums, start, i - 1);
            quickSort(nums, i + 1, end);
        }
    }

    private static int partition1(int[] nums, int start, int end) {
        int pivot = start;
        while (start != end) {
            while (start < end && nums[end] >= nums[pivot]) {
                end--;
            }
            while (start < end && nums[start] < nums[pivot]) {
                start++;
            }
            swap(nums, start, end);
        }
        swap(nums, start, pivot);
        return start;
    }
}
