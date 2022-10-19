package leetcode.greedy.sub0452;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] points;
//        points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        System.out.println(solution.findMinArrowShots(points) + " = 2");
//        points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
//        System.out.println(solution.findMinArrowShots(points) + " = 4");
//        points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
//        System.out.println(solution.findMinArrowShots(points) + " = 2");
//        points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
//        System.out.println(solution.findMinArrowShots(points) + " = 2");
        points = new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println(solution.findMinArrowShots(points) + " = 2");
    }

    class Solution {
        public int findMinArrowShots(int[][] points) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int numOfPoint = points.length;
            // 1、边界问题：只有一个气球
            if (numOfPoint == 1) {
                return 1;
            }

            // 2、按气球所在x轴的 xEnd 排序
            /* ----- 空间 O(log n) ----- */
            /* +++++ 时间 O(n log n) +++++ */
            Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

            // 射出弓箭的数量
            int numOfArrow = 1;
            // 被当前弓箭引爆的第一个气球的 xend 位置
            int prevXEnd = points[0][1];
            // 3、开始射箭，并寻找会被引爆的气球
            /* +++++ 遍历数组：时间 O(3n) +++++ */
            for (int i = 1; i < numOfPoint; i++) {
                // 3.1、`curXStart > prevXEnd` => 当前坐标区间内已没有气球，射出第二支箭
                /* +++++ 条件判断：时间 O(n) +++++ */
                if (points[i][0] > prevXEnd) {
                    // 3.2、增加弓箭数量
                    ++numOfArrow;
                    // 3.3、记录引爆位置
                    prevXEnd = points[i][1];
                }
            }

            // 4、返回射出的弓箭数量
            return numOfArrow;
        }
    }

}
