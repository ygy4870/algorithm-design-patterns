package com.ygy.study.algorithm.leetcode.number;

/**
 *  最小K个数
 *  难度中等
 *
 *  设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *      示例：
 *      输入： arr = [1,3,5,7,2,4,6,8], k = 4
 *      输出： [1,2,3,4]
 *
 *      提示：
 *      0 <= len(arr) <= 100000
 *      0 <= k <= min(100000, len(arr))
 */
public class NumberExercise0005 {

    public static void main(String[] args) {

        int[] arr = {1,3,5,7,2,4,6,8};
//        int[] arr = {5,8,1,3,4,9,5,6,10};
        int k = 4;
//        int[] arrK = smallestK(arr, k);
        int[] arrK = smallestK2(arr, k);
        System.out.println(arrK);
    }

    /**
     * 快排
     * @param arr
     * @param k
     * @return
     */
    public static int[] smallestK(int[] arr, int k) {
        if (null == arr || k < 0 || k > arr.length) {
            return null;
        }
        fastSortK(arr, 0, arr.length - 1, k);
        int[] tempArr = new int[k];
        for (int i = 0; i < k; i++) {
            tempArr[i] = arr[i];
        }
        return tempArr;
    }

    /**
     * 快排（尾递归，内存应该和迭代一样）
     * @param arr
     * @param left
     * @param right
     * @param k
     */
    private static void fastSortK(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= key) {
                j--;
            }

            while (i < j && arr[i] <= key) {
                i++;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = key;
        if (i == k - 1) {
            return;
        }
        if (i > k-1) {
            fastSortK(arr, left, i - 1, k);
        } else {
            fastSortK(arr, i + 1, right, k);
        }
    }

    /**
     * 迭代，测试发现 和尾递归差不多
     * @param arr
     * @param k
     * @return
     */
    public static int[] smallestK2(int[] arr, int k) {
        if (null == arr || k < 0 || k > arr.length) {
            return null;
        }
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int index = fastSortK(arr, left, right);
            if (k-1==index) {
                break;
            }
            if (index>k-1) {
                right = index-1;
            } else {
                left = index + 1;
            }
        }
        int[] tempArr = new int[k];
        for (int i = 0; i < k; i++) {
            tempArr[i] = arr[i];
        }
        return tempArr;
    }


    private static int fastSortK(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }

            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

}
