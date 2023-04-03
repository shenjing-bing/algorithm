package 数组;

/**
 * @author shenjingbin
 * @date 2021/10/24
 */
public class _4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] arr = {100001};
        int[] arr1 = {100000};
        System.out.println(findMedianSortedArrays(arr, arr1));
    }

    /**
     *
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int mid = m + (n - m + 1) / 2;
        int left = 0;
        int right = m;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = mid - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }
        int i = left;
        int j = mid - i;
        System.out.println(i + " " + j);
        int length = nums1.length + nums2.length;
        int minNums1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int maxNums1 = i == nums1.length ? Integer.MAX_VALUE : nums1[i];
        int minNums2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int maxNums2 = j == nums2.length ? Integer.MIN_VALUE : nums2[j];
        System.out.println(minNums1 + "-" + maxNums1 + "-" + minNums2 + "-" + maxNums2);
        if ((length & 1) == 1) {
            return Math.max(minNums1, minNums2);
        } else {
            return ((double) (Math.max(minNums1, minNums2) + Math.min(maxNums1, maxNums2))) / 2;
        }
    }

    /**
     * 1。 先伪合并两个有序数组，然后求中位数
     * 2。 首先对于两个有序数组，我们只需要循环length/2次便可以得到中位数，由于偶数时，中位数是两个数
     * 3。 所以我们用两个临时变量才存储这两个数
     * 4。 如何伪合并两个数组，aStart,和bStart分别代表每次遍历时，nums1数组和nums2数组的位置
     * 5。 如果aStart没有指向最后一个变量并且当前bStart也不是最后一个变量或者nums2[bStart]>nums1[aStart],这是将aStart右移
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
                System.out.println(aStart);
            } else {
                right = nums2[bStart++];
                System.out.println(bStart);
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }
}
