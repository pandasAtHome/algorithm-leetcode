package leetcode.devide_and_conquer.sub0932;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(Arrays.toString(solution.beautifulArray(2)) + " = [2, 1]");
        System.out.println(Arrays.toString(solution.beautifulArray(3)) + " = [2, 3, 1]");
        System.out.println(Arrays.toString(solution.beautifulArray(4)) + " = [4, 2, 3, 1]");
        System.out.println(Arrays.toString(solution.beautifulArray(5)) + " = [4, 2, 3, 5, 1]");
        System.out.println(Arrays.toString(solution.beautifulArray(6)) + " = [4, 6, 2, 3, 5, 1]");
        System.out.println(Arrays.toString(solution.beautifulArray(7)) + " = [4, 6, 2, 7, 3, 5, 1]");
        System.out.println(Arrays.toString(solution.beautifulArray(8)) + " = [8, 4, 6, 2, 7, 3, 5, 1]");
        System.out.println(Arrays.toString(solution.beautifulArray(9)) + " = [8, 4, 6, 2, 7, 3, 5, 9, 1]");
    }

    class Solution {
        Map<Integer, int[]> cache;
        public int[] beautifulArray(int n) {
            // 初始化：缓存
            this.cache = new HashMap<>();
            cache.put(1, new int[]{1});
            /* ----- 空间 O(n log n) ----- */
            /* +++++ 时间 O(n log n) +++++ */
            return divide(n);
        }

        private int[] divide(int n) {
            // 1、读取缓存
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            // 2、初始化 长度为n 的数组
            /* ----- 空间 O(n) ----- */
            int[] result = new int[n];
            int i = 0;
            // 3、把【偶数】放入左边
            /* ----- 空间 O(log n) ----- */
            /* +++++ 时间 O(log n) +++++ */
            int[] left = divide(n / 2);
            /* +++++ 时间 O(n) +++++ */
            for (int num : left) {
                result[i++] = num * 2;
            }
            // 4、把【奇数】放入右边
            int[] right = divide((n + 1) / 2);
            for (int num : right) {
                result[i++] = num * 2 - 1;
            }
            // 5、记录当前数值的结果
            cache.put(n, result);
            return result;
        }
    }
}
