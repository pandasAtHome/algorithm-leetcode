package leetcode.greedy.sub0763;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij") + " = " + Arrays.toString(new int[]{9, 7, 8}));

    }

    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> result = new ArrayList<>();
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int length = s.length();
            // 1、字符串只包含一个字符
            if (length == 1) {
                result.add(1);
                return result;
            }

            // 2、转换为字符数组
            /* ----- 字符数组：空间 O(n) ----- */
            /* +++++ 遍历数组：时间 O(2n) +++++ */
            char[] chars = s.toCharArray();
            // 3、记录每个字符最后一次出现的位置
            /* ----- 字符位置数组：空间 O(1) ----- */
            int[] locations = new int[26];
            /* +++++ 遍历数组：时间 O(3n) +++++ */
            for (int i = 0; i < length; i++) {
                /* +++++ 数组赋值：时间 O(n) +++++ */
                locations[chars[i] - 'a'] = i;
            }

            // 4、寻找每个片段的最后一个字符，裁剪片段
            // 上一个片段区间的开始位置
            int prevStart = -1;
            // 当前片段中，最晚出现的字符的位置
            int end = -1;
            /* +++++ 遍历数组：时间 O(3n) +++++ */
            for (int i = 0; i < length; i++) {
                /* +++++ 最大值：时间 O(n) +++++ */
                end = Math.max(locations[chars[i] - 'a'], end);
                // 4.1、截取条件：`当前字符位置` == `当前片段中位置最后的一个字符的位置`
                /* +++++ 条件判断：时间 O(n) +++++ */
                if (i == end) {
                    result.add(i - prevStart);
                    prevStart = i;
                }
            }

            return result;
        }
    }
}
