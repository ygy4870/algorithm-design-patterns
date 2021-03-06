package com.ygy.study.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *      给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *      示例 1:
 *      输入: "abcabcbb"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *      示例 2:
 *      输入: "bbbbb"
 *      输出: 1
 *      解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *      示例 3:
 *      输入: "pwwkew"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *           请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class StringExercise0001 {

    public static void main(String[] args) {

        String str = "ryghretyaretrrrr";
        int maxLen = lengthOfLongestSubstring(str);
        System.out.println(maxLen);

        int maxLen2 = lengthOfLongestSubstring2(str);
        System.out.println(maxLen2);

    }

    /**
     * 动态滑动窗口方式
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {
        if (null == str || "" == str) {
            return 0;
        }
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            sb.append(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {

                boolean repeat = false;
                for (int k = 0; k < sb.length(); k++) {
                    if (sb.charAt(k) == str.charAt(j)) {
                        // 重复
                        repeat = true;
                        break;
                    }
                }

                if (repeat) {
                    if (sb.length() > max) {
                        max = sb.length();
                    }
                    sb.delete(0, sb.length());
                    break;
                } else {
                    sb.append(str.charAt(j));
                }
            }
        }
        return max;
    }

    /**
     * 用map记录下标，可以减少循环
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring2(String str) {
        if (null == str || 0 == str.length()) {
            return 0;
        }
        if (1 == str.length()) {
            return 1;
        }

        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            Integer index = map.getOrDefault(str.charAt(i), -1);
            if (start < index) {
                int currentMax = i - start;
                max = max > currentMax ? max : currentMax;
                start = index + 1;
            }
            map.put(str.charAt(i), i);
        }

        return max;
    }

}
