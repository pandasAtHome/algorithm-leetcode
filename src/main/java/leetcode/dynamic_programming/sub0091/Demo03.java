package leetcode.dynamic_programming.sub0091;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
        System.out.println(solution.numDecodings("111100116") + " = 0");
        System.out.println(solution.numDecodings("11110116") + " = 9");
        System.out.println(solution.numDecodings("1111011") + " = 6");
        System.out.println(solution.numDecodings("11110") + " = 3");
        System.out.println(solution.numDecodings("12") + " = 2");
        System.out.println(solution.numDecodings("226") + " = 3");
        System.out.println(solution.numDecodings("0") + " = 0");
    }

    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int iTo2 = 0, iTo1 = 1, iTo0 = 0;
            int prev = 0, cur;
            for (int i = 1; i <= n; i++) {
                iTo0 = 0;
                cur = s.charAt(i - 1) - '0';
                if (cur > 0) {
                    iTo0 = iTo1;
                }
                if (i > 1 && prev > 0 && (prev * 10 + cur) < 27) {
                    iTo0 += iTo2;
                }
                iTo2 = iTo1;
                iTo1 = iTo0;
                prev = cur;
            }
            return iTo0;
        }
    }
}
