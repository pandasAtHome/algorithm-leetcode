package leetcode.data_structure.sub0149;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] points;
        points = new int[][]{
                {1, 1},
                {2, 2},
                {3, 3}
        };
        System.out.println(solution.maxPoints(points) + " = 3");
        // [1,4], [2,3], [3,2], [4,1]
        points = new int[][]{
                {1, 1},
                {3, 2},
                {5, 3},
                {4, 1},
                {2, 3},
                {1, 4}
        };
        System.out.println(solution.maxPoints(points) + " = 4");
    }

    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            if (n <= 2) {
                return n;
            }
            int maxLen = 0, curLen;
            // 同一斜率(直线)上的点的数量
            Map<String, Integer> slopePointCnt;
            // 起始点
            int[] pointStart;
            // x轴长度 | y轴长度 | 最大公因数 | 半数点的数量
            int deltaX, deltaY, hcf, half = n / 2;
            // 斜率
            String slope;
            /* +++++ 时间 O(n) +++++ */
            for (int i = 0; i < n; i++) {
                /*
                 * 细节问题1：最大长度 >= 剩余的未检测的点的数量
                 * 细节问题2：最大长度 > 半数点的数量
                 */
                if (maxLen >= n - i || maxLen > half) {
                    break;
                }
                /* ----- 空间 O(n) ----- */
                slopePointCnt = new HashMap<>();
                pointStart = points[i];
                curLen = 0;
                for (int j = i + 1; j < n; j++) {
                    // 求出直线的斜率
                    deltaX = pointStart[0] - points[j][0];
                    deltaY = pointStart[1] - points[j][1];
                    // 最大公约数
                    hcf = gcd(deltaX, deltaY);
                    // 斜率 = 对边 / 邻边
                    slope = (deltaY / hcf) + "/" + (deltaX / hcf);
                    if (slopePointCnt.containsKey(slope)) {
                        slopePointCnt.put(slope, slopePointCnt.get(slope) + 1);
                    } else {
                        slopePointCnt.put(slope, 2);
                    }
                    curLen = Math.max(curLen, slopePointCnt.get(slope));
                }
                maxLen = Math.max(maxLen, curLen);
            }
            return maxLen;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}
