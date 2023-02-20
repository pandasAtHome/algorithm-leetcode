package leetcode.data_structure.sub0313;

import java.util.PriorityQueue;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}) + " = 32");
        System.out.println(solution.nthSuperUglyNumber(1, new int[]{2, 3, 5}) + " = 1");
    }

    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            /* ----- 空间 O(n) ----- */
            int[] result = new int[n];
            result[0] = 1;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            // 把 质数数组入队
            /* +++++ 时间 O(k) +++++ */
            for (int i = 0; i < primes.length; i++) {
                // 格式：[质数, 质数索引, 丑数索引]
                pq.add(new int[]{primes[i], i, 0});
            }
            // 遍历需要找的第 n 个丑数
            /* +++++ 时间 O(n) +++++ */
            for (int i = 1; i < n; ) {
                int[] poll = pq.poll();
                int val = poll[0], primeIdx = poll[1], nextResultIdx = poll[2] + 1;
                if (val != result[i - 1]) {
                    // 找到下一个丑数
                    result[i++] = val;
                }
                pq.add(new int[]{
                        result[nextResultIdx] * primes[primeIdx],
                        primeIdx,
                        nextResultIdx
                });
            }

            return result[n - 1];
        }
    }
}
