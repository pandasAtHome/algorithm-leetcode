package leetcode.data_structure.sub0020;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.isValid("()") + " = true");
        System.out.println(solution.isValid("()[]{}") + " = true");
        System.out.println(solution.isValid("(]") + " = false");
        System.out.println(solution.isValid("){") + " = false");
    }

    class Solution {
        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                // 奇数：无效
                return false;
            }
            // 1、定义一个 括号 map，用于匹配左右括号
            Map<Character, Character> map = new HashMap<>();
            // 左 => 右
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            map.put('?', '?');  // 未知符号
            Deque<Character> stack = new ArrayDeque<>();
            stack.push('?');
            // 2、遍历查询各字符
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    // 2.1、左边的括号，入队
                    stack.push(ch);
                } else if (!map.get(stack.pop()).equals(ch)) {
                    // 2.2、右边的括号，不成对
                    return false;
                }
            }
            return stack.size() == 1;
        }
    }
}
