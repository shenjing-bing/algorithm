package com.xxx.leetcode;

import java.util.HashMap;

/**
 * @description: https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked
 * @author: liujiabing
 * @create: 2023-05-23 17:43
 **/

public class _3_无重复字符的最长子串 {
    /**
     * @description: 思考什么时候左指针应该移动
     * @description: 1.当没有重复字符时，右指针向右移动
     * @description: 2.当出现重复字符时，切当前字符不在左指针左侧时,左指针应该移动到重复字符的下一个位置
     * @description:
     * @param args
     */
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
            maxLength= Math.max(maxLength,right-left+1);
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