package com.ygy.study.algorithm.leetcode.string;

import java.util.*;

/**
 * 重复的DNA序列 难度-中等
 *
 *      所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *      编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *      示例：
 *      输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *      输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class StringExercise0003 {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//        String s = "AAAAAAAAAAA";
        List<String> repeatedDnaSequences = findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);

        List<String> repeatedDnaSequences2 = findRepeatedDnaSequences2(s);
        System.out.println(repeatedDnaSequences2);

        List<String> repeatedDnaSequences3 = findRepeatedDnaSequences3(s);
        System.out.println(repeatedDnaSequences3);
    }

    /**
     * 暴力法，用Map存储每一个可能值的数量------------leetcode 本以为不是最优，居然成功
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (null==s || s.length() < 11) {
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length()-10; i++) {
            String subStr = s.substring(i, i + 10);
            Integer count = map.get(subStr);
            if (null==count) {
                map.put(subStr, 1);
            } else {
                map.put(subStr, ++count);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    /**
     * 固定滑动窗口--------leetcode 超时
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences2(String s) {
        List<String> list = new ArrayList<>();
        if (null == s || s.length() < 11) {
            return list;
        }
        Set<String> strSet = new HashSet<>();
        for (int i = 0; i <= s.length() - 10-1; i++) {
            // substring 产生新的字串，也是需要内存的，可以优化
            String sub = s.substring(i, i+10);
            for (int j = i+1; j <= s.length() - 10; j++) {
                if (sub.equals(s.substring(j, j+10))) {
                    strSet.add(sub);
                    break;
                }
            }
        }
        list.addAll(strSet);
        return list;
    }

    /**
     * 滑动窗口，优化版--------leetcode 超时
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences3(String s) {
        List<String> list = new ArrayList<>();
        if (null == s || s.length() < 11) {
            return list;
        }
        Set<String> strSet = new HashSet<>();
        for (int i = 0; i <= s.length() - 10-1; i++) {
            for (int j = i+1; j <= s.length() - 10; j++) {

                // 替换 substring 截取字串造成的内存浪费
                boolean success = true;
                for (int k = 0; k < 10; k++) {
                    if (s.charAt(i+k) != s.charAt(j+k)) {
                        success = false;
                        break;
                    }
                }

                if (success) {
                    strSet.add(s.substring(i, i+10));
                    break;
                }
            }
        }
        list.addAll(strSet);
        return list;
    }



}
