package com.ArrayList;

/**
 * @version 1.0
 * @authoe 李祥基
 * leetcode 209
 */
public class MinSubArrayLen {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            //滑动窗口法
            int left = 0, right = 0;
            int subLength = 0;//滑动窗口的长度
            int sum = 0;// 滑动窗口数值之和
            int result = Integer.MAX_VALUE;
            for (; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    subLength = right - left + 1;
                    result = Math.min(result, subLength);
                    sum -= nums[left];
                    left++;
                }
            }
            // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }
}
