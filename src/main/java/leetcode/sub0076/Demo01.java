package leetcode.sub0076;

import java.util.Arrays;
import java.util.HashMap;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.minWindow("ABC", "ABC"));
    }

    class Solution {
        public String minWindow(String s, String t) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int sLen = s.length();
            int tLen = t.length();
            /* 1、细节处理
             * 细节问题1：`s的长度` < `t的长度`
             * 细节问题2：`s的长度 == 1` && `t的长度 == 1` && `s != t`
             */
            if (sLen < tLen || (sLen == 1 && tLen == 1 && !s.equals(t))) {
                return "";
            }

            // 遍历的字符
            char ch;
            // 当前阶段的最小窗口：窗口开始位置、窗口大小
            int minWinStartIndex = 0, minWinSize = sLen + 1;
            // 下一个滑动窗口：左指针、右指针、包含的字符数(属于字符串t的字符)、窗口大小
            int left = 0, right = 0, numOfNextWinContains = 0, nextWinSize;

            /* ----- 定义 2个 固定长度的数组：空间 O(C) ----- */
            // 2、记录 `字符串t` 中，各字符的 `出现次数` 以及 `出现过的字符`
            // 字符串t 中各字符的计数(由于没有指定字符范围，所以使用一个 128 位的数组存储)
            int[] cntOfChars = new int[128];
            // 字符串t 中出现过的字符(由于没有指定字符范围，所以使用一个 128 位的数组存储)
            boolean[] charExists = new boolean[128];
//            HashMap<Character, Boolean> charExists = new HashMap<>();
            /* +++++ 遍历字符串：时间 O(2n) +++++ */
            for (int i = 0; i < tLen; i++) {
                /* +++++ 字符查询：时间 O(3n) +++++ */
                ch = t.charAt(i);
                /* +++++ 计数：时间 O(n) +++++ */
                cntOfChars[ch]++;
                /* +++++ 赋值：时间 O(n) +++++ */
                charExists[ch] = true;
//                charExists.put(ch, true);
            }

            // 3、从左到右滑动窗口，找出所有符合条件的子串，筛选出最小子串
            /* +++++ 遍历字符串：时间 O(2n) +++++ */
            for (; right < sLen; right++) {
                // 4、找出符合条件的子串
                /* +++++ 字符查询：时间 O(3n) +++++ */
                ch = s.charAt(right);
                // 4.1、跳过非目标字符(不在字符串t中的字符)
                /* +++++ 目标字符 获取 & 判断：时间 O(2n) +++++ */
                if (!charExists[ch]) {
//                if (!charExists.containsKey(ch)) {
                    showRight(right, ch, numOfNextWinContains, left, minWinStartIndex, minWinSize, cntOfChars);
                    continue;
                }
                // 4.2、找到目标字符 => 字符计数 -1
                /* +++++ 目标字符 获取 & 自增 & 条件判断：时间 O(3n) +++++ */
                if (--cntOfChars[ch] >= 0) {
                    // 4.3、是需要寻找的字符(字符串t中，未在当前窗口中出现的字符) => 找到字符数 +1
                    ++numOfNextWinContains;
                }
                showRight(right, ch, numOfNextWinContains, left, minWinStartIndex, minWinSize, cntOfChars);

                // 5、尝试缩小窗口，找出符合条件的最小子串
                /* +++++ 窗口长度判断：时间 O(n) +++++ */
                while (numOfNextWinContains == tLen) {
                    // 5.1、找到长度更小的新窗口 => 更新最小窗口信息
                    if ((nextWinSize = right - left + 1) < minWinSize) {
                        minWinStartIndex = left;
                        minWinSize = nextWinSize;
                    }
                    ch = s.charAt(left);
                    // 5.2、找到目标字符 => 目标字符计数 +1
                    if (charExists[ch] && ++cntOfChars[ch] > 0) {
//                    if (charExists.containsKey(ch) && ++cntOfChars[ch] > 0) {
                        // 5.3、是需要寻找的字符(字符串t中，未在当前窗口中出现的字符) => 找到字符数 -1
                        --numOfNextWinContains;
                    }
                    // 5.4、缩小新窗口长度
                    left++;
                    showLeft(minWinStartIndex, minWinSize, ch, cntOfChars, numOfNextWinContains, left);
                }
            }

            return minWinSize > sLen ? "" : s.substring(minWinStartIndex, minWinStartIndex + minWinSize);
        }

    }

    public static void showRight(int r, char sr, int numOfNextWinContains, int l, int minWinStartIndex, int windowSize, int[] chars) {
        String s = "r = " + r
                + ", s[r] = " + sr
                + ", num_of_win_contains = " + numOfNextWinContains
                + ", l = " + l
                + ", window_start_index = " + minWinStartIndex
                + ", window_size = " + windowSize
                + ", chars = {A:" + chars['A'] + ",B:" + chars['B'] + ",C:" + chars['C'] + "}"
                ;
        System.out.println(s);
    }

    public static void showLeft(int minWinStartIndex, int windowSize, char sl, int[] chars, int numOfNextWinContains, int l) {
        String s = "\twindow_start_index = " + minWinStartIndex
                + ", window_size = " + windowSize
                + ", s[l] = " + sl
                + ", chars = {A:" + chars['A'] + ",B:" + chars['B'] + ",C:" + chars['C'] + "}"
                + ", num_of_win_contains = " + numOfNextWinContains
                + ", l = " + l
                ;
        System.out.println(s);
    }

}
