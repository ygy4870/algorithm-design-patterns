package com.ygy.study.algorithm.leetcode.string;

/**
 * 最长回文子串 难度中等
 *      给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 *      示例 1：
 *
 *      输入: "babad"
 *      输出: "bab"
 *      注意: "aba" 也是一个有效答案。
 *
 *
 *      示例 2：
 *
 *      输入: "cbbd"
 *      输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringExercise0002 {

    public static void main(String[] args) {

//        String str = "babad";
        String str = "bababab";
//        String str = "aba";
        String result = longestPalindrome(str, 0, str.length() - 1);
        System.out.println(result);

        String result2 = longestPalindrome(str);
        System.out.println(result2);
    }

    /**
     * 暴力递归，两边夹，发现符合条件可返回
     * 时间复杂度O(N^2)
     * 由于不是尾递归，有可能造成栈溢出
     * @param s
     * @param left
     * @param right
     * @return
     */
    public static String longestPalindrome(String s, int left, int right) {
        if (null == s || s.length() < 2) {
            return s;
        }
        if (left == right) {
            return s.substring(left, right + 1);
        }
        int i = left;
        int j = right;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i++;
            j--;
        }
        if (i >= j) {
            return s.substring(left, right + 1);
        }
        String leftStr = longestPalindrome(s, left, right - 1);
        String rightStr = longestPalindrome(s, left + 1, right);
        if (leftStr.length() > rightStr.length()) {
            return leftStr;
        }
        return rightStr;
    }

    /**
     * 中心发散法
     * 时间复杂度O(N^2)
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        // 中心点
        int medianIndex = s.length() / 2;
        int start = 0;
        int end = 0;

        // 先往右移动
        int right = medianIndex;
        while (right < s.length()) {
            if (s.length() - right < (end - start) / 2) {
                break;
            }
            int len1 = lenPalindrome(s, right, right);
            int len2 = lenPalindrome(s, right, right + 1);
            int len = len1 > len2 ? len1 : len2;
            if (len > end - start) {
                start = right - len / 2;
                end = right + len / 2 + 1;
            }
            right++;
        }

        // 往左移动
        int left = medianIndex;
        while (left > 0) {
            if (left < (end - start) / 2) {
                break;
            }
            int len1 = lenPalindrome(s, left, left);
            int len2 = lenPalindrome(s, left - 1, left);
            int len = len1 > len2 ? len1 : len2;
            if (len > end - start) {
                start = left - len / 2;
                end = left + len / 2 + 1;
            }
            left--;
        }

        return s.substring(start, end);
    }

    private static int lenPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return right - left + 1;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 马拉车算法
     */

}
