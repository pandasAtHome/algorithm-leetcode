package leetcode.bitwise_operation.sub0318;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}) + " = 16");
        System.out.println(solution.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}) + " = 4");
        System.out.println(solution.maxProduct(new String[]{"a","aa","aaa","aaaa"}) + " = 0");
    }

    class Solution {
        public int maxProduct(String[] words) {
            // 数组长度
            /* ----- 空间 O(1) ----- */
            int n = words.length;
            // 结果
            int res = 0;
            // 每个单词对应的位掩码
            /* ----- 空间 O(n) ----- */
            int[] mem = new int[n];
            /* +++++ 时间 O(mn + n^2) +++++ */
            for (int i = 0; i < n; i++) {
                // 1、计算每个单词的位掩码
                /* +++++ 时间 O(m) +++++ */
                mem[i] = convert(words[i]);
                // 2、与其他单词比较，判断两个单词是否存在相同的字母
                /* +++++ 时间 O(n) +++++ */
                // 细节问题1：每次只需对【当前单词】&【之前的单词】比较
                for (int j = 0; j < i; j++) {
                    if ((mem[i] & mem[j]) == 0) {
                        // 3、计算单词长度乘积，并求出最大值
                        res = Math.max(res, words[i].length() * words[j].length());
                    }
                }
            }
            return res;
        }

        private int convert(String word) {
            /* 位掩码：(映射关系如下)
             *  - 字母：zyxwvutsrqponmlkjihgfedcba
             *  - 掩码：11111111111111111111111111
             */
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                // 先与 a 相减，得到当前字母对应的位，
                // 再向 左移动 相应的位数
                // 最后，执行 按位或 标记当前字母所在的位
                mask |= (1 << (word.charAt(i) - 'a'));
            }
            return mask;
        }
    }
}
