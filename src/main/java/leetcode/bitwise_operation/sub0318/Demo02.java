package leetcode.bitwise_operation.sub0318;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}) + " = 16");
        System.out.println(solution.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}) + " = 4");
        System.out.println(solution.maxProduct(new String[]{"a","aa","aaa","aaaa"}) + " = 0");
    }

    class Solution {
        public int maxProduct(String[] words) {
            // 数组长度； 单词长度
            int n = words.length, len;
            // 结果
            int res = 0, mask;
            int[][] mem = new int[n][2];
            for (int i = 0; i < n; i++) {
                len = words[i].length();
                mask = convert(words[i], len);
                mem[i] = new int[]{mask, len};
                for (int j = 0; j < i; j++) {
                    if ((mask & mem[j][0]) == 0) {
                        res = Math.max(res, len * mem[j][1]);
                    }
                }
            }
            return res;
        }

        private int convert(String word, int length) {
            int mask = 0;
            for (int i = 0; i < length; i++) {
                mask |= 1 << (word.charAt(i) - 'a');
            }
            return mask;
        }
    }
}
