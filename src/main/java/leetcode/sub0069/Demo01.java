package leetcode.sub0069;

import com.sun.org.apache.bcel.internal.generic.LOR;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
//        System.out.println(solution.mySqrt(4) + " = 2");
        System.out.println(solution.mySqrt(6) + " = 2");
        System.out.println(solution.mySqrt(8) + " = 2");
        System.out.println(solution.mySqrt(9) + " = 3");
        System.out.println(solution.mySqrt(15) + " = 3");
    }

    class Solution {
        public int mySqrt(int x) {
            // 1、细节问题1：`0 <= x <= 1`：返回自身
            if (x <= 1) {
                return x;
            }
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int low = 0, high = x, mid;
            // 2、取中值，计算算术平方根
            /* +++++ 二分查找：时间 O(log n) +++++ */
            while (low <= high) {
                /* +++++ 赋值：时间 O(1) +++++ */
                /* +++++ 计算：时间 2 * O(1) +++++ */
                // 2.1、每次取 `中值`
                mid = (high + low) / 2;
                // 2.2、平方根 与 x 比较大小
                if (x / mid == mid) {
                    // 2.1、`mid^2 = x`
                    return mid;
                }
                /* +++++ 计算：时间 O(1) +++++ */
                /* +++++ 比较：时间 O(1) +++++ */
                /* +++++ 赋值 ｜ 返回：时间 O(1) +++++ */
                if (x / mid < mid) {
                    // 2.2、`mid^2 > x`
                    high = mid;
                } else if (x / (mid + 1) < mid + 1) {
                    // 2.3、`mid^2 < x < (mid + 1)^2`
                    return mid;
                } else {
                    // 2.4、`mid^2 < (mid + 1)^2 < x`
                    low = mid;
                }
            }

            return -1;
        }
    }

    class Solution2 {
        public int mySqrt(int x) {
            // 细节问题1：`0 <= x <= 1`：返回自身
            if (x <= 1) {
                return x;
            }
            int low = 0, high = x, mid;
            int res = -1;
            while (low <= high) {
                mid = (high + low) / 2;
                if ((long) mid * mid <= x) {
                    res = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return res;
        }
    }
}
