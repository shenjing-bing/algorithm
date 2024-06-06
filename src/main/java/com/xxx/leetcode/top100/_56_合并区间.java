package com.xxx.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode.cn/problems/merge-intervals/
 * @author: liujiabing
 * @create: 2023-05-27 19:42
 **/

public class _56_合并区间 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (res.isEmpty()||(res.get(res.size() - 1))[1]<left){
                res.add(new int[]{left,right});
            }else {
                res.get(res.size() - 1)[1] = Math.max(right,res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}