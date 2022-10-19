package leetcode.double_pointer.sub0633;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.judgeSquareSum(5) + " = true");
        System.out.println(solution.judgeSquareSum(3) + " = false");
        System.out.println(solution.judgeSquareSum(7) + " = false");
    }

    class Solution {
        public boolean judgeSquareSum(int c) {
            // 1、细节问题1：对于 `0 <= c <= 2`，均存在 $a^2 + b^2 = c$
            if (0 <= c && c <= 2) {
                return true;
            }
            /*
             * 2、定义一对首尾指针，向中间靠拢，寻找 `a` 和 `b`
             * 3、求出 c 的开方值，并向下取整
             */
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            long left = 0, right = (long) Math.floor(Math.sqrt(c));
            // 4、细节问题2：$a^2 + b^2$ 可能超过 `int` 的取值范围，所以需要用 `long`
            long sum;
            /* +++++ 遍历取值范围：时间 O(n) +++++ */
            while (left <= right) {
                /* +++++ 计算、赋值、判断、移动指针：时间 n * 6 * O(1) +++++
                 * 计算：O(3)
                 *  - 两数相乘：2 * O(1)
                 *      - left * left
                 *      - right * right
                 *  - 乘值相加：O(1)
                 * 赋值：O(1)
                 * 条件判断：O(1)
                 *  - sum > c
                 * 移动指针：O(1)
                 *  - right--
                 */
                if ((sum = left * left + right * right) > c) {
                    // 4.1、$a^2 + b^2 > c$ , **右指针**向中心靠拢
                    right--;
                } else if (sum < c) {
                    // 4.2、$a^2 + b^2 < c$ , **左指针**向中心靠拢
                    left++;
                } else {
                    // 4.3、$a^2 + b^2 = c$ , 获取到正确结果
                    return true;
                }
            }

            return false;
        }
    }

    // 数学解法：费马平方和定理
    class Solution2 {
        public boolean judgeSquareSum(int c) {
            for (int base = 2; base * base < c; base++) {
                if (c % base != 0) {
                    continue;
                }
                int exp = 0;
                while (c % base == 0) {
                    c /= base;
                    exp++;
                }
                if (base % 4 != 3 && exp % 2 != 0) {
                    return false;
                }
            }
            return c % 4 != 3;
        }
    }
}
