package leetcode.dynamic_programming.sub0139;

import java.util.*;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")) + " = true");
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")) + " = true");
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")) + " = false");
    }

    class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            // 1、定义一个列表：记录 目标字符串 s 中，以 `每个位置的字母` 为结尾 是否能匹配上
            /* ----- 空间 O(n) ----- */
            boolean[] matches = new boolean[n + 1];
            // 2、把词典 转为 hash 表
            HashSet<String> wordSet = new HashSet<>(wordDict);
            // 3、边界问题1：第一个为空格，一定能匹配上
            matches[0] = true;
            // 4、遍历 截止到 目标字符串s 的每个位置字母，找出 所有子串
            /* +++++ 时间 O(n^2) +++++ */
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    // 目标字符串 s 的 `[0, j)` 子串 已经匹配上，且 `[j, i)` 在 hash 词典中
                    if (matches[j] && wordSet.contains(s.substring(j, i))) {
                        matches[i] = true;
                        break;
                    }
                }
            }

            return matches[n];
        }
        
    }
}
