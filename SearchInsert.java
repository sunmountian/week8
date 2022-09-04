package com.ArrayList;

/**
 * @version 1.0
 * @authoe 李祥基
 * leetcode 35
 */
public class SearchInsert {
    class Solution {
        public int searchInsert(int[] nums, int target) {
/*            //暴力破解法
            // 分别处理如下三种情况
            // 目标值在数组所有元素之前
            // 目标值等于数组中某一个元素
            // 目标值插入数组中的位置
            for (int i = 0; i < nums.length; i++) {
                if (target >= nums[i]) return i;
            }
            // 目标值在数组所有元素之后的情况
            return nums.length;*/

/*            //二分法 左闭右闭区间[left,right]
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) right = mid - 1;
                else if (nums[mid] < target) left = mid + 1;
                    // 1. 目标值等于数组中某一个元素
                else return mid;
            }
            // 2.目标值在数组所有元素之前
            // 3.目标值插入数组中
            // 4.目标值在数组所有元素之后
            return right + 1;*/


            //二分法 左闭右开区间[left,right)
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) return right = mid;
                else if (nums[mid] < target) return left = mid + 1;
                else return mid;
            }
            return right;
        }

    }
}
