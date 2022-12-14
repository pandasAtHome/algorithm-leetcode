package leetcode.greedy.sub0455;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        // TO TEST
        System.out.println(solution.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
    }

    class Solution {
        public int findContentChildren(int[] children, int[] cookies) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int numOfChild = children.length;
            int numOfCookie = cookies.length;
            int satisfy = 0;  // 满足度
            int i = 0;  // 当前饼干数量
            // 1、边界问题：空队列(没有饼干 `0 <= s.length <= 3 * 10⁴`)
            if (numOfCookie == 0) {
                return satisfy;
            }

            // 2、把2个数组从小到大排序：使用快排(请参考：https://github.com/hustcc/JS-Sorting-Algorithm)
            /* ----- 空间 O(log n) ----- */
            /* +++++ 时间 O(n log n) +++++ */
            Arrays.sort(children);
            Arrays.sort(cookies);

            // 3、分配饼干：最小尺寸给最小胃口值
            // 3.1、边界问题：小孩都吃饱 or 饼干分配完
            /* +++++ 遍历数组：时间 O(n) +++++ */
            while (satisfy < numOfChild && i < numOfCookie) {
                // 3.2、满足判断
                /* +++++ 满足度判断，遍历N次：时间 O(n) +++++ */
                /* +++++ 饼干计数，遍历N次：时间 O(n) +++++ */
                if (cookies[i++] >= children[satisfy]) {
                    // 3.3、`饼干尺寸 ≥ 胃口值` => 满足度+1
                    satisfy++;
                }
                // 3.4、`饼干尺寸 < 胃口值` => 丢弃
            }
            // 4、返回满足度
            return satisfy;
        }
    }
}
