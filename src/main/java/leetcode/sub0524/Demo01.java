package leetcode.sub0524;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();

        System.out.println(solution.findLongestWord("abpcplea", Arrays.asList("ale", "panda", "apple", "monkey", "plea")) + " = apple");
        System.out.println(solution.findLongestWord("abpcplea", Arrays.asList("a","b","c")) + " = a");
        System.out.println(solution.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea", "abpcplaaa","abpcllllll","abccclllpppeeaaaa")) + " = apple");
    }

    // 双指针 + 排序
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            /* 1、对字符串数组，按元素长度倒序
             *  - 长度大的在前面
             *  - 长度相同，字母序较小者在前面
             *
             * 细节问题1：先对字符串数组，按各元素的长度倒序，寻找到`长度最长`且`字母序最小`的元素，即可退出循环
             */
            /* ----- 空间 O(log m) ----- */
            /* +++++ 时间 O(2m + m log m) +++++ */
            dictionary.sort((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length());
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            // l = 单词的长度
            // n = 搜索的字符串长度
            int l, n = s.length();
            // 单词的指针，搜索字符串的指针
            int idxW, idxS;
            // 2、细节问题2：可能会多次获取 `搜索的字符串s` 中的元素，转换成字符数组
            /* ----- 空间 O(n) ----- */
            /* +++++ 时间 O(n) +++++ */
            char[] chars = s.toCharArray();
            // 3、遍历字符串数组，找出第一个符合条件的元素
            /* +++++ 遍历字符串数组：时间 O(m) +++++ */
            for (String word : dictionary) {
                // 3.1、重置：单词指针 & 字符串指针
                /* +++++ 赋值：时间 3 * O(m) +++++ */
                idxW = idxS = 0;
                // 3.2、获取单词长度
                l = word.length();
                /* 3.3、遍历 单词&字符串，匹配字符
                 *  - idxW >= m：当前单词符合条件
                 *  - idxS >= n：当前单词不符合条件
                 */
                /* +++++ 循环条件判断：时间 2 * O(l + n) +++++ */
                while (idxW < l && idxS < n) {
                    // 3.4、移动字符串指针idxS，比较字符串中的每个字符
                    /* +++++ 获取单词字符：时间 O(3l) +++++ */
                    /* +++++ 获取字符串字符 & 移动指针：时间 O(2n) +++++ */
                    /* +++++ 字符比较：时间 O(l + n) +++++ */
                    if (chars[idxS++] == word.charAt(idxW)) {
                        // 3.5、匹配到相同字母，移动单词指针 idxW
                        idxW++;
                    }
                }
                // 4、找到第一个目标值，查找结束
                /* +++++ 长度比较：时间 O(m) +++++ */
                if (idxW == l) {
                    return word;
                }
            }

            // 5、没找到目标值
            return "";
        }
    }

    /**
     * 动态规划 + 排序
     *  - 单纯使用 动态规划，耗时更短，但消耗的资源多
     */
    class Solution2 {
        public String findLongestWord(String s, List<String> dictionary) {
            int n = s.length();
            // 1、分析：字符串中，当前字符 & 下一字符的索引矩阵
            int[][] nextCharMatrix = parseNextCharIndexMatrix(s);
            // 2、按单词长度倒序，字母序较小者排前面
            dictionary.sort((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length());
            // 3、单词匹配
            // 下一字符，单词字符指针，字符串s指针，单词长度
            int idxN, idxW, idxS, m;
            for (String word : dictionary) {
                idxW = idxS = 0;
                m = word.length();
                while (idxW < m) {
                    idxN = nextCharMatrix[idxS][word.charAt(idxW) - 'a'];
                    if (idxN == n) {
                        break;
                    }
                    idxW++;
                    idxS = idxN + 1;
                }
                if (idxW == m) {
                    return word;
                }
            }
            return "";
        }

        // 下一个字符的索引矩阵
        private int[][] parseNextCharIndexMatrix(String s) {
            int n = s.length();
            int[][] charMatrix = new int[n + 1][26];
            Arrays.fill(charMatrix[n], n);
            for (int i = n - 1; i >= 0; --i) {
                int ch = s.charAt(i);
                for (int j = 0; j < 26; ++j) {
                    if (ch == (char) ('a' + j)) {
                        charMatrix[i][j] = i;
                    } else {
                        charMatrix[i][j] = charMatrix[i + 1][j];
                    }
                }
            }
            return charMatrix;
        }
    }
}
