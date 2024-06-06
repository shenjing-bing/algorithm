package com.xxx.leetcode.top100;

import java.util.HashMap;

/**
 * @description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked
 * @author: liujiabing
 * @create: 2023-05-23 17:43
 **/

public class _3_无重复字符的最长子串 {
    public static void main(String[] args) {
        lengthOfLongestSubstring1("abba");
    }

    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            if (map.containsKey(c)&&left<=map.get(c)){
                    left = map.get(c)+1;
            }
            map.put(c,right);
            maxLength= Math.max(maxLength,left-right+1);
            System.out.println(maxLength);
            right++;
        }
        return maxLength;
    }









    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if (map.containsKey(c)){
                left = Math.max(left,map.get(c) + 1);
            }
            map.put(c,right);
            max = Math.max(max,right-left+1);
            System.out.println(max);
            right++;
        }
        return max;
    }
}