package com.ArrayList;

/**
 * @version 1.0
 * @authoe 李祥基
 * leetcode 27
 */
public class RemoveElement {
    class Solution {
        public int removeElement(int[] nums, int val) {

            /*//暴力破解法
            int length = nums.length;
            for (int i = 0; i < nums.length; i++) {
                // 发现需要移除的元素，就将数组集体向前移动一位
                if (nums[i] == val){
                    for (int j = i + 1; j < nums.length; j++) {
                        nums[j - 1] = nums[j];
                    }
                    i--;// 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                    length--;// 此时数组的大小-1
                }
            }
            return length;*/




            //快慢指针法
            int slow = 0, fast = 0;
            for (; fast < nums.length; fast++) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
            }
            return slow;
        }
    }
}
