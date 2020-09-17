package com.ygy.study.algorithm.leetcode.number;

/**
 * 寻找两个正序数组的中位数(难度困难)
 *
 *      给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *      请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *      你可以假设 nums1 和 nums2 不会同时为空。
 *
 *      示例 1:
 *
 *      nums1 = [1, 3]
 *      nums2 = [2]
 *
 *      则中位数是 2.0
 *
 *
 *      示例 2:
 *
 *      nums1 = [1, 2]
 *      nums2 = [3, 4]
 *
 *      则中位数是 (2 + 3)/2 = 2.5
 *
 *      来源：力扣（LeetCode）
 *      链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberExercise0002 {

    public static void main(String[] args) {

        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);

        double median2 = findMedianSortedArrays2(nums1, nums2);
        System.out.println(median2);
    }

    /**
     * 归并排序，写一下，不过明显达不到要求的时间复杂度
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.0;
        }
        int[] temp = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums1[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        int median1 = temp[(temp.length - 1) / 2];
        int median2 = temp[(temp.length) / 2];

        return (median1 + median2) / 2.0;
    }

    /**
     * 归并排序，由于两个数组的长度已知，
     *      中位数1=（num1.len + num2.len-1）/ 2
     *      中位数2=（num1.len + num2.len） / 2
     *      所以不用遍历完
     *      时间复杂度依然不满足要求
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0.0;
        }
        int median1Index = (nums1.length + nums2.length - 1) / 2;
        int median2Index = (nums1.length + nums2.length) / 2;


        int[] temp = new int[median2Index + 1];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length && k < temp.length) {
            if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums1[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length && k < temp.length) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length && k < temp.length) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        int median1 = temp[median1Index];
        int median2 = temp[median2Index];

        return (median1 + median2) / 2.0;
    }
    
}
