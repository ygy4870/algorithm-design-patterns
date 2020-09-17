package com.ygy.study.algorithm.leetcode.number;

import com.alibaba.fastjson.JSON;

/**
 *   两数之和
 *   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 *   你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *   示例:
 *
 *   给定 nums = [2, 7, 11, 15], target = 9
 *
 *   因为 nums[0] + nums[1] = 2 + 7 = 9
 *   所以返回 [0, 1]
 *
 */
public class NumberExercise0001 {

    public static void main(String[] args) {
        int[] nums = {2, 9, 7, 11, 15};
        int target = 9;
        int[] twoSum = twoSum(nums, target);
        System.out.println(JSON.toJSON(twoSum));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }

}
