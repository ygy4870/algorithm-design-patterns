package com.ygy.study.algorithm.leetcode.number;

/**
 * 旋转数组
 *      给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *      示例 1:
 *      输入: [1,2,3,4,5,6,7] 和 k = 3
 *      输出: [5,6,7,1,2,3,4]
 *      解释:
 *      向右旋转 1 步: [7,1,2,3,4,5,6]
 *      向右旋转 2 步: [6,7,1,2,3,4,5]
 *      向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 *      示例 2:
 *      输入: [-1,-100,3,99] 和 k = 2
 *      输出: [3,99,-1,-100]
 *      解释:
 *      向右旋转 1 步: [99,-1,-100,3]
 *      向右旋转 2 步: [3,99,-1,-100]
 *
 *      说明:
 *      尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *      要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 */
public class NumberExercise0003 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
//        rotate(nums, k);
//        rotate2(nums, k);
        rotate3(nums, k);
        System.out.println(nums);
    }

    /**
     * k次循环复制
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return;
        }
        k = k % nums.length;
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 新数组来回复制
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return;
        }
        k = k % nums.length;
        int[] newNums = new int[nums.length];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            newNums[index++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            newNums[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    /**
     * k长度数组复制
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return;
        }
        k = k % nums.length;
        int[] tempNums = new int[k];// k 而不是 nums.length
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            tempNums[index++] = nums[i];
        }
        for (int i = nums.length - k - 1; i >=0; i--) {
            nums[i+k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tempNums[i];
        }
    }

}
