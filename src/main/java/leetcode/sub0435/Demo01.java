package leetcode.sub0435;

import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 4}, {1, 3}}) + " = 1");
    }

    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int length = intervals.length;
            // 1、边界问题：只有一个区间
            if (length < 2) {
                return 0;
            }
            // 2、按 end 值，排列区间顺序
            /* +++++ 二分排序：时间 O(log n) +++++ */
            // (1) Comparator 比较类：(before Java8)
            //  - 优点：效率较高
            //  - 缺点：代码量多，可读性差
//            Arrays.sort(intervals, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o1[1] - o2[1];
//                }
//            });
            // (2) lambda 表达式：(in Java8)(算法中，推荐)
            //  - 优点：效率较高
            Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
            // (3) 链式操作：(in Java8)(生产中，推荐)
            //  - 优点：可读性高
            //  - 缺点：效率较低
//            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
            int result = 0;
            // 3、记录上一区间的结束值
            int prevEnd = intervals[0][1];
            // 4、排除不符合的区间
            /* +++++ 遍历数组：时间 O(n) +++++ */
            // 4.1、边界问题：从第二个区间开始匹配
            for (int i = 1; i < length; i++) {
                /* +++++ 条件判断：时间 O(n) +++++ */
                /* +++++ 赋值：时间 O(n) +++++ */
                if (intervals[i][0] < prevEnd) {
                    // 4.2、不合规 => 移除
                    result++;
                } else {
                    // 4.3、合规 => 使用
                    prevEnd = intervals[i][1];
                }
            }
            // 5、返回移除的区间数量
            return result;
        }
    }
}
