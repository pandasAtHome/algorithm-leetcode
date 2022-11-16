package leetcode.devide_and_conquer.sub0241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.diffWaysToCompute("11") + " = [11]");
        System.out.println(solution.diffWaysToCompute("2-1-1") + " = [0,2]");
        System.out.println(solution.diffWaysToCompute("2*3-4*5") + " = [-34,-14,-10,-10,10]");
    }

    class Solution {
        // 表达式
        String expression;
        // 表达式字符数组
        char[] chars;
        // 各子表达式结果
        Map<String, List<Integer>> dp;

        public List<Integer> diffWaysToCompute(String expression) {
            this.expression = expression;
            this.chars = expression.toCharArray();
            this.dp = new HashMap<>();

            return diffWaysToCompute(0, chars.length);
        }

        private List<Integer> diffWaysToCompute(int start, int end) {
            List<Integer> result = new ArrayList<>();
            if (start >= end) {
                return result;
            }
            // 1、读取旧记录
            String key = expression.substring(start, end);
            if (dp.containsKey(key)) {
                return dp.get(key);
            }

            // 2、计算表达式不同组合结果
            char opt;
            /* +++++ 时间 O(n) +++++ */
            for (int i = start; i < end; i++) {
                opt = chars[i];
                // 3、找出各个`运算符`位置
                if (!(opt == '-' || opt == '+' || opt == '*')) {
                    // 跳过非运算符
                    continue;
                }
                // 4、以它为中间点，划分为左右两部分表达式，并计算结果
                // 拆分（左部分）：`[start, i)`
                List<Integer> left = diffWaysToCompute(start, i);
                // 拆分（右部分）：`[i + 1, end)`
                List<Integer> right = diffWaysToCompute(i + 1, end);
                /* +++++ 时间 O(ml) +++++ */
                for (Integer l : left) {
                    for (Integer r : right) {
                        // 5、再以当前`运算符`进行运算
                        result.add(calculate(l, opt, r));
                    }
                }
            }

            if (result.isEmpty()) {
                // 纯数字：当前字符串中，不包含操作符
                result.add(Integer.valueOf(key));
            }
            // 6、细节问题1：使用动态规划，记录每个子表达式的结果
            dp.put(key, result);

            return result;
        }

        // 运算
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
