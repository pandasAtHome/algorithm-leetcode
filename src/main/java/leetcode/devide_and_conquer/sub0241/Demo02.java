package leetcode.devide_and_conquer.sub0241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.diffWaysToCompute("11") + " = [11]");
        System.out.println(solution.diffWaysToCompute("2-1-1") + " = [0,2]");
        System.out.println(solution.diffWaysToCompute("2*3-4*5") + " = [-34,-14,-10,-10,10]");
    }

    class Solution {
        Map<String, List<Integer>> dp = new HashMap<>();

        public List<Integer> diffWaysToCompute(String expression) {
            if (dp.containsKey(expression)) {
                return dp.get(expression);
            }

            List<Integer> result = new ArrayList<>();
            char opt;
            for (int i = 0; i < expression.length(); i++) {
                opt = expression.charAt(i);
                if (opt == '-' || opt == '+' || opt == '*') {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    for (Integer l : left) {
                        for (Integer r : right) {
                            result.add(calculate(l, opt, r));
                        }
                    }
                }
            }

            if (result.isEmpty()) {
                result.add(Integer.valueOf(expression));
            }
            dp.putIfAbsent(expression, result);

            return result;
        }

        private Integer calculate(Integer left, char opt, Integer right) {
            switch (opt) {
                case '-':
                    return left - right;
                case '+':
                    return left + right;
                case '*':
                    return left * right;
                default:
                    return 0;
            }
        }
    }
}
