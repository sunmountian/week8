package com.ArrayList;

/**
 * @version 1.0
 * @authoe 李祥基
 * leetcode 283
 */
public class MoveZeroes {
    class Solution{
        public void moveZeroes(int nums[]){
            if (nums == null || nums.length == 1) return;
            int slow = 0 , fast = 0;
            while (fast < nums.length){
                if (nums[fast] != 0 ){
                    nums[slow++] = nums[fast++];
                }else {
                    fast++;
                }
            }
            while (slow < nums.length){
                nums[slow++] = 0 ;
            }
            return;
        }
    }
}
