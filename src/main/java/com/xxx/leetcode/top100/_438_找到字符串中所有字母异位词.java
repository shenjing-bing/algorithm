package com.xxx.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
 * @author: liujiabing
 * @create: 2023-05-23 17:59
 **/

public class _438_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length()<p.length()) {
            return result;
        }
        int[] difference = new int[26];
        for (int i = 0; i < p.length(); i++) {
            difference[s.charAt(i)-'a']++;
            difference[p.charAt(i)-'a']--;
        }
        int diff = Arrays.stream(difference).sum();
        if (diff==0) {
            result.add(0);
        }

        int left = 0;
        int right = p.length();
        while (right<s.length()){
            if (difference[s.charAt(left)-'a']==1) {
                diff--;
            }else if (difference[s.charAt(right)-'a']==0){
                diff++;
            }
            difference[s.charAt(left)-'a']--;
            if (difference[s.charAt(right)-'a']==-1) {
                diff--;
            }else if (difference[s.charAt(right)-'a']==0){
                diff++;
            }
            difference[s.charAt(right)-'a']++;
            if (diff==0) {
                result.add(left+1);
            }
            left++;
            right++;
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length()<p.length())return result;
        int[] window = new int[26];
        int[] pWindow = new int[26];
        for (int i = 0; i < p.length(); i++) {
            window[s.charAt(i)-'a']++;
            pWindow[p.charAt(i)-'a']++;
        }
        if (Arrays.equals(window,pWindow)) {
            result.add(0);
        }
        int left = 1;
        int right = p.length();
        while (right<s.length()){
            window[s.charAt(left-1)-'a']--;
            window[s.charAt(right)-'a']++;
            if (Arrays.equals(window,pWindow)) {
                result.add(left);
            }
            left++;
            right++;
        }
        return result;
    }
}