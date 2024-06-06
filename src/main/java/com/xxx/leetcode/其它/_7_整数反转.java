package com.xxx.leetcode.其它;

/**
 * @description: https://leetcode.cn/problems/reverse-integer/
 * @author: liujiabing
 * @create: 2023-05-22 22:12
 **/

public class _7_整数反转 {

    public int reverse(int x) {
        int res=0;
        while(x!=0){
            int temp = res*10+x%10;
            if(temp/10!=res){
                return 0;
            }
            res=temp;
            x=x/10;
        }
        return res;
    }
}