package leetcode.sub0135;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = (new Demo01()).new Solution();
        // TO TEST
        System.out.println("+++++ " + solution.candy(new int[] { 1, 0, 2 }) + " = 5");
        System.out.println("+++++ " + solution.candy(new int[] { 1, 2, 2 }) + " = 4");
        System.out.println("+++++ " + solution.candy(new int[] { 1, 3, 4, 5, 2 }) + " = 11");
    }

    class Solution {
        public int candy(int[] ratings) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int length = ratings.length;
            // 1、边界问题：只有一个孩子(1 <= n <= 2 * 10⁴)
            if (length < 2) {
                return length;
            }
            // 2、每个孩子至少分配到 1 个糖果
            /* ----- 定义一个糖果数组：空间 O(n) ----- */
            int[] numOfCandy = new int[length];
            /* +++++ 遍历数组：时间 O(3n) +++++ */
            Arrays.fill(numOfCandy, 1);

            // 3、从左往右遍历，找出右边较大者
            // 3.1、边界问题：[1, length)
            /* +++++ 遍历数组：时间 O(3n) +++++ */
            for (int i = 1; i < length; i++) {
                // 3.2、给右边分数高的孩子发放糖果
                // right = i,  left = i - 1
                /* +++++ N次较大者判断：时间 O(n) +++++ */
                if (ratings[i] > ratings[i - 1]) {
                    // `right分数 > left分数` => `right糖果 = left糖果 + 1`
                    numOfCandy[i] = numOfCandy[i - 1] + 1;
                }
            }

            // 4、从右往左遍历，找出左边较大者
            // 4.1、边界问题：[0, length - 2]
            /* +++++ 遍历数组：时间 O(3n) +++++ */
            for (int i = length - 2; i >= 0; i--) {
                // 4.2、给左边分数高的孩子发放糖果
                // left = i,  right = i + 1
                /* +++++ N次较大者判断：时间 O(n) +++++ */
                if (ratings[i] > ratings[i + 1]) {
                    // `left分数 > right分数` => `left糖果 = max(left糖果, right糖果 + 1)`
                    numOfCandy[i] = Math.max(numOfCandy[i], numOfCandy[i + 1] + 1);
                }
            }

            // 5、统计需要发放的糖果数量
            /*
              此处不推荐使用流式计算，原因如下：
               - stream 适用场景：
                   - size > 10000 (此时，`stream 效率` > `for 循环`)
                   - 有多步处理的迭代逻辑(提高可读性)
             */
//            Arrays.stream(numOfCandy).sum();
            int totalNumOfCandy = 0;
            /* +++++ 数组遍历：时间 O(n) +++++ */
            for (int num : numOfCandy) {
                /* +++++ 数值累加：时间 O(n) +++++ */
                totalNumOfCandy += num;
            }
            return totalNumOfCandy;
        }
    }
}
