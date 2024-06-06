package com.xxx.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked
 * @author: liujiabing
 * @create: 2023-05-22 22:22
 **/

public class _9_字母异位词分组 {

    public List<List<String>> groupAnagrams11(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = chars.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return map.values().stream().collect(Collectors.toList());

    }
    /**
     * 字母相同，但排列不同的字符串，排序后都一定是相同的。因为每种字母的个数都是相同的，那么排序后的字符串就一定是相同的，
     * 注意 groupingBy 算子计算完以后，返回的是一个 Map<String, List<String>>，map 的键是每种排序后的字符串，
     * 值是聚合的原始字符串，我们只关心值，所以我们最后 new ArrayList<>(map.values())。
     * 设 n 是数组长度，k 是字符串最大长度
     * 时间复杂度 ： O(nklogk)。每个字符串排序，排序时间复杂度 klog(k) 排序 n 个，就是 O(nklogk)，groupingBy 的时间复杂度是 O(n) 的，所以整体是 O(nklogk)。
     * 空间复杂度： O(nk)。 groupingBy 后产生的 HashMap 会存所有的字符串。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
       return new ArrayList<>( Arrays.stream(strs).collect(Collectors.groupingBy(t -> {
            char[] chars = t.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        })).values());
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
        return new ArrayList<>( Arrays.stream(strs).collect(Collectors.groupingBy(t -> {
            int[] counts = new int[26];
            for (int i = 0; i < t.length(); i++) {
                counts[t.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if(counts[i]!=0){
                    sb.append((char)i+'a');
                    sb.append(counts[i]);
                }
            }
            return String.valueOf(sb);
        })).values());
    }
}