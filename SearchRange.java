package com.ArrayList;

/**
 * @version 1.0
 * @authoe 李祥基
 * leetcode 34
 */
public class SearchRange {

/*    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int leftBorder = getLeftBorder(nums,target);
            int rightBorder = getRightBorder(nums,target);
            //情况一：target 在数组范围的右边或者左边
            if (leftBorder == -2 || rightBorder == -2)
                return new int[]{-1,-1};
            //情况三：target 在数组范围中，且数组中存在target
            if (rightBorder - leftBorder > 1)
                return new int[]{leftBorder + 1, rightBorder - 1};
            //情况二：target 在数组范围中，且数组中不存在target
            return new int[]{-1, -1};

        }

        private int getRightBorder(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target)  right = mid - 1;
                    // 寻找右边界，nums[mid] == target的时候更新left
                else {
                    left = mid + 1;
                    rightBorder = left;
                }
            }
            return rightBorder;
        }

        private int getLeftBorder(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int leftBorder = -2;
            while (left <= right) {
                int mid = (left + right) / 2;
                // 寻找左边界，nums[middle] == target的时候更新right
                if (nums[mid] >= target) {
                    right = mid - 1;
                    leftBorder = right;
                } else left = mid + 1;
            }
            return leftBorder;
        }
    }*/


    // 解法2
// 1、首先，在 nums 数组中二分查找 target；
// 2、如果二分查找失败，则 binarySearch 返回 -1，表明 nums 中没有 target。此时，searchRange 直接返回 {-1, -1}；
// 3、如果二分查找成功，则 binarySearch 返回 nums 中值为 target 的一个下标。然后，通过左右滑动指针，来找到符合题意的区间

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int index = binarySearch(nums, target); // 二分查找

            if (index == -1) { // nums 中不存在 target，直接返回 {-1, -1}
                return new int[]{-1, -1}; // 匿名数组
            }
            // nums 中存在 targe，则左右滑动指针，来找到符合题意的区间
            int left = index;
            int right = index;
            // 向左滑动，找左边界
            /*  while (left - 1 >= 0 && nums[left - 1] == target )*/
            while (left - 1 >= 0 && nums[left - 1] == nums[index]) { // 防止数组越界。逻辑短路，两个条件顺序不能换
                left--;
            }
            // 向左滑动，找右边界
            while (right + 1 < nums.length && nums[right + 1] == nums[index]) { // 防止数组越界。
                right++;
            }
            return new int[]{left, right};
        }

        public int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target)
                    right = mid - 1;
                else if (nums[mid] < target)
                    left = mid + 1;
                else return mid;
            }
            return -1;
        }
    }
}
