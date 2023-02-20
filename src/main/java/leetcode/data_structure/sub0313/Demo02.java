package leetcode.data_structure.sub0313;

import java.util.PriorityQueue;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}) + " = 32");
        System.out.println(solution.nthSuperUglyNumber(1, new int[]{2, 3, 5}) + " = 1");
    }

    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(1);
            int x;
            while (n-- > 0) {
                System.out.println(pq);
                x = pq.poll();
                if (n == 0) {
                    return x;
                }
                for (int prime : primes) {
                    if (prime <= Integer.MAX_VALUE / x) {
                        pq.add(prime * x);
                    }
                    if (x % prime == 0) {
                        break;
                    }
                }
            }

            return -1;
        }
    }
}
