package leetcode.dynamic_programming.sub0010;

import utils.ArrayUtil;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
//        System.out.println(solution.isMatch("aa", "a") + " + false");
//        System.out.println(solution.isMatch("aa", "a*") + " + true");
//        System.out.println(solution.isMatch("ab", ".*") + " + true");
//        System.out.println(solution.isMatch("aab", "c*a*b") + " + true");
        System.out.println(solution.isMatch("mississippi", "mis*is*p*.") + " + false");
//        System.out.println(solution.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s") + " + true");
    }

    class Solution {
        public boolean isMatch(String s, String p) {
            int n = s.length();
            int m = p.length();
            // 1、定义一个数组：`dp[i][j]` 表示 `s[0:i]` 与 `p[0:j]` 是否匹配上
            /* ----- 空间 O(mn) ----- */
            boolean[][] dp = new boolean[n + 1][m + 1];
            // 2、细节问题1：把 `匹配规则 p` 转为 字符数组 （加快 对 p 的字符检索）
            char[] patterns = p.toCharArray();
            /* ----- 空间 O(m) ----- */
            // 3、边界问题1：`dp[0][0]` 表示 空字符串，一定能匹配上
            dp[0][0] = true;
            // 4、初始化：找出 `匹配规则 p` 中的 所有 `*`
            /* +++++ 时间 O(m) +++++ */
            for (int j = 1; j <= m; j++) {
                if (patterns[j - 1] == '*') {
                    // 细节问题2：由于每次出现 `*` 之前，都能匹配到有效字符，所以不用添加 `j > 1` 的判断
                    dp[0][j] = dp[0][j - 2];
                }
            }
            // 目标字符/规则的前一个字符/规则的当前字符
            char target, prevPattern, curPattern;
            // 5、字符匹配
            /* +++++ 时间 O(mn) +++++ */
            for (int i = 1; i <= n; i++) {
                target = s.charAt(i - 1);
                for (int j = 1; j <= m; j++) {
                    curPattern = patterns[j - 1];
                    if (curPattern == '*') {
                        // 5.1、匹配到 `*` ：
                        // 默认：不匹配（即：舍弃 `target`）
                        dp[i][j] = dp[i][j - 2];
                        prevPattern = patterns[j - 2];
                        if (target == prevPattern || prevPattern == '.') {
                            // 匹配到 ：`x*` or `.*`
                            dp[i][j] |= dp[i - 1][j];
                        }
                    } else if (curPattern == '.' || curPattern == target) {
                        // 5.2、匹配单个字符：`.` or `字符`
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }

            return dp[n][m];
        }
    }
}
