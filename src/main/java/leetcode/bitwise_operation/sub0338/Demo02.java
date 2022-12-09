package leetcode.bitwise_operation.sub0338;

import java.util.Arrays;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(Arrays.toString(solution.countBits(2)) + " = [0,1,1]");
        System.out.println(Arrays.toString(solution.countBits(5)) + " = [0,1,1,2,1,2]");
    }

    class Solution {
        int[] result;
        public int[] countBits(int n) {
            result = new int[n + 1];
            int cnt, num;
            for (int i = 0; i <= n; i++) {
                cnt = 0;
                num = i;
                while (num > 0) {
                    cnt += (num & 1);
                    num >>= 1;
                }
                result[i] = cnt;
            }
            return result;
        }
    }
}
