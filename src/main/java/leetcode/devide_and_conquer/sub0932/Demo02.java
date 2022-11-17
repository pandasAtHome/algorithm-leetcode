package leetcode.devide_and_conquer.sub0932;

import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(Arrays.toString(solution.beautifulArray(4)) + " = [2,1,4,3]");
        System.out.println(Arrays.toString(solution.beautifulArray(5)) + " = [3,1,2,5,4]");
        System.out.println(Arrays.toString(solution.beautifulArray(6)) + " = [3,1,2,5,4]");
        System.out.println(Arrays.toString(solution.beautifulArray(7)) + " = [3,1,2,5,4]");
        /**
         * - [1, 2, 3, 4]
         *
         * - [1, 2, 3, 4, 5]
         */
    }

    class Solution {
        public int[] beautifulArray(int n) {
            List<List<Integer>> dp = initDp(n);
            for (int i = 2; i <= n; i++) {
                List<Integer> list = new ArrayList<>();
                for (Integer num : dp.get((i + 1) / 2)) {
                    list.add(num * 2 - 1);
                }
                for (Integer num : dp.get(i / 2)) {
                    list.add(num * 2);
                }
                dp.add(list);
            }

            int[] result = new int[n];
            int i = 0;
            for (Integer num : dp.get(n)) {
                result[i++] = num;
            }
            return result;
        }

        private List<List<Integer>> initDp(int n) {
            List<List<Integer>> dp = new ArrayList<>(n + 1);
            dp.add(new ArrayList<>());
            List<Integer> list = new ArrayList<>();
            list.add(1);
            dp.add(list);
            return dp;
        }
    }
}
