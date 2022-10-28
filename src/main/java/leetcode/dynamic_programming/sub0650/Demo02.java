package leetcode.dynamic_programming.sub0650;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.minSteps(11) + " = 11");
        System.out.println(solution.minSteps(9) + " = 6");
        System.out.println(solution.minSteps(3) + " = 3");
        System.out.println(solution.minSteps(1) + " = 0");
    }

    class Solution {
        public int minSteps(int n) {
            int ans = 0;
            for (int i = 2; i * i <= n; i++) {
                while (n % i == 0) {
                    n /= i;
                    ans += i;
                }
            }
            if (n > 1) {
                ans += n;
            }
            return ans;
        }
    }
}
