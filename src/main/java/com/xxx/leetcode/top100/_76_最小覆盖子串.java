package com.xxx.leetcode.top100;

/**
 * @description: https://leetcode.cn/problems/minimum-window-substring/
 * @author: liujiabing
 * @create: 2023-05-26 22:51
 **/

public class _76_最小覆盖子串 {
    public static void main(String[] args) {
        minWindow("ADOBECODEBANC","ABC");
    }

    public static String minWindow(String s, String t) {
        if (s.length()<t.length()) {
            return "";
        }
        int[] hash = new int[128];
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]--;
        }
        int left = 0;
        int right = 0;
        String res = "";
        int count = t.length();
        while (right<s.length()){
            hash[s.charAt(right)]++;
            if(hash[s.charAt(right)]<=0){
                count--;
            }
            while(count==0&&hash[s.charAt(left)]>0){
                System.out.println("left="+left+"right="+right);
                System.out.println(hash[s.charAt(left)]);
                hash[s.charAt(left++)]--;
            }
            if (count==0){
                if(res==""||res.length()>right-left+1){
                    res = s.substring(left,right+1);
                }
            }
            right++;
        }
        return res;
    }
}