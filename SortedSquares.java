package com.ArrayList;

/**
 * @version 1.0
 * @authoe 李祥基
 * leetvode 977
 */
public class SortedSquares {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            //双指针法
            int[] result = new int[nums.length];
            int cur = nums.length - 1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                if (nums[left] * nums[left] > nums[right] * nums[right]) {
                    result[cur] = nums[left] * nums[left];
                    left++;
                    cur--;
                } else {
                    result[cur] = nums[right] * nums[right];
                    right--;
                    cur--;
                }
            }
            return result;
        }
    }
}
