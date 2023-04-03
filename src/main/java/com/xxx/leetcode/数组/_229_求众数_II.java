package 数组;

import java.util.*;

/**
 * @author shenjingbin
 * @date 2021/10/22
 */
public class _229_求众数_II {
    //给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 2, 1, 2, 3};
        System.out.println(majorityElement(a));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count1 > 0 && nums[i] == a) {
                count1++;
            } else if (count2 > 0 && nums[i] == b) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                a = nums[i];
            } else if (count2 == 0) {
                count2++;
                b = nums[i];
            } else {
                count1--;
                count2--;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (count1 > 0 && num == a) {
                cnt1++;
            }
            if (count2 > 0 && num == b) {
                cnt2++;
            }
        }
        // 检测元素出现的次数是否满足要求
        List<Integer> ans = new ArrayList<>();
        if (count1 > 0 && cnt1 > nums.length / 3) {
            ans.add(a);
        }
        if (count2 > 0 && cnt2 > nums.length / 3) {
            ans.add(b);
        }
        return ans;
    }

    public List<Integer> majorityElement1(int[] nums) {
        int number = nums.length / 3;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > number) {
                arrayList.add(entry.getKey());
            }
        }

        return arrayList;
    }
}
