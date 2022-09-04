package com.ArrayList;

/**
 * @version 1.0
 * @authoe 李祥基
 * leetcode 704
 */
public class Search {
    class Solution {
        public int search(int[] nums, int target) {
            //闭区间[left,right]
            // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
            if (target < nums[0] || target > nums[nums.length - 1]) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target)
                    right = mid - 1;
                else if (nums[mid] < target)
                    left = mid + 1;
                else
                    return mid;

            }
            return -1;

 /*           //左闭右开[left,right)
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target)
                    right = mid;
                else if (nums[mid] < target)
                    left = mid + 1;
                else
                    return mid;
            }
            return -1;*/
        }
    }
}
