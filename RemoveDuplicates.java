package com.ArrayList;

/**
 * @version 1.0
 * @authoe 李祥基
 * leetcode 26
 */
public class RemoveDuplicates {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 1) return nums.length;
            int slow = 0, fast = 1;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    nums[++slow] = nums[fast++];
                } else fast++;
            }
            return slow + 1;
        }
    }
}
