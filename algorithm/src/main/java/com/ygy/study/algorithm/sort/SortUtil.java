package com.ygy.study.algorithm.sort;

import java.util.StringJoiner;

public class SortUtil {

    public static void main(String[] args) {
        int[] nums = {5,8,1,3,4,9,5,6,10};
//        int[] nums = {1,3,5,7,2,4,6,8};
////        bubbleSort(nums);
//        mergeSortRecursion(nums, 0, nums.length-1);
//
//        insertSort(nums);
        fastSort(nums);
        StringJoiner sj = new StringJoiner(",","","");
        for (int i = 0; i < nums.length; i++) {
            sj.add(""+nums[i]);
        }
        System.out.println(sj.toString());
//
//        int[] nums = {10,8,1,3,4,9,5,6};
//        merge(nums, 0, nums.length-1);
//        System.out.println("");
    }

    /**
     * 冒泡排序
     * 时间复杂度 O（N）
     * 空间复杂度 O（1）
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        if (null==nums || nums.length<1) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * 时间复杂度 1+2+3+......+(n=1) = O(N)
     * 空间复杂度 O（1）
     * @param nums
     */
    public static void insertSort(int[] nums) {
        if (null==nums || nums.length<1) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            insertLast(nums,0,i);
        }
    }

    /**
     * 数组，right+1下标值插入有序数组（left 到 right下标）
     * @param nums
     * @param left
     * @param right
     */
    private static void insertLast(int[] nums, int left, int right) {
        int lastValue = nums[right + 1];
        int i = right;
        for (; i >= left ; i--) {
            if (lastValue>nums[i]) {
                break;
            }
            nums[i+1] = nums[i];
        }
        nums[++i] = lastValue;
    }

    /**
     * 快排
     * @param nums
     */
    public static void fastSort(int[] nums) {
        fastSort(nums, 0, nums.length-1);
    }

    private static void fastSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 确定一个key作为比较值，比他小的在左边，否在在右边，这里拿第一个
        int key = nums[left];
        int i = left;
        int  j=right;
        while (i<j) {
            // 从右往左找比key小的值，顺序很重要，先从右往左
            while (nums[j] >= key && i < j) {
                j--;
            }

            // 从左往右找比key大的值
            while (nums[i] <= key && i < j) {
                i++;
            }

            // 交互找到的值
            if (i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left]=nums[i];
        nums[i]=key;

        fastSort(nums, left, i-1);
        fastSort(nums, i+1, right);
    }

    /**
     * 归并排序(递归)
     * @param nums
     */
    public static void mergeSortRecursion(int[] nums) {

    }


    public static void mergeSortForeach(int[] nums) {
        if (null == nums || nums.length < 2) {
            return;
        }
        // 经分析，归并的次数 = nums.length-1
        for (int i = 1; i < nums.length-1; i++) {

        }

    }

    /**
     * 堆排序
     * @param nums
     */
    public static void heapSort(int[] nums) {

    }



}
