package leetcode.sub0406;

import java.util.Arrays;
import java.util.LinkedList;


public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] result;
        result = solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        show(result, "[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]");
    }

    /**
     * 链表存储
     * 第3步：元素入队查找，时间复杂度为 O(n/2)
     */
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int length = people.length;
            // 1、边界问题：只有一个人
            if (length == 1) {
                return people;
            }

            // 2、身高排序：从大到小
            /* ----- 空间 O(log n) ----- */
            /* +++++ 时间 O(n log n) +++++ */
            Arrays.sort(people, (a, b) -> {
                if (a[0] == b[0]) {
                    // 2.1、身高相同，【人数少】的在前面
                    return a[1] - b[1];
                }
                // 2.2、身高不同，【高】的在前面
                return b[0] - a[0];
            });
            // people = [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4],]

            // 结果
            /* ----- 结果集链表：空间 O(n) ----- */
            LinkedList<int[]> result = new LinkedList<>();
            // 3、入队：把人数数量作为编号
            /* +++++ 数组遍历：时间 O(n) +++++ */
            for (int[] person : people) {
                // 3.1、核心：每次新成员入队，都是当前队列中的最佳位置，从而最终结果最优
                /* +++++ node(index) 元素查找：时间 O(n/2) +++++ */
                result.add(person[1], person);
            }

            /* +++++ 数组遍历：时间 O(n) +++++ */
            /* ----- 结果集数组：空间 O(n) ----- */
            return result.toArray(new int[length][]);

        }
    }

    /**
     * 数组存储
     * 第3步：元素入队查找，时间复杂度为 O(n)
     */
    class Solution2 {
        /*
        空间：
         */
        public int[][] reconstructQueue(int[][] people) {
            int length = people.length;
            // 1、边界问题：只有一个人
            if (length == 1) {
                return people;
            }

            // 2、身高从小到大排序
            Arrays.sort(people, (a, b) -> {
                if (a[0] == b[0]) {
                    // 2.1、身高相同，则人数多的排前面
                    return b[1] - a[1];
                }
                // 2.2、身高不同，则矮的排前面
                return a[0] - b[0];
            });
            // people = [[4,4],[5,2],[5,0],[6,1],[7,1],[7,0],]

            // 结果
            int[][] result = new int[length][];
            // 此人的正确位置编号：[0, length)
            int pos = -1;
            // 3、寻找每个人的最终站位，入列
            for (int[] person : people) {
                pos = person[1];
                // 时间复杂度：O(n)
                for (int i = 0; i < length; i++) {
                    if (result[i] != null) {
                        continue;
                    }
                    if (--pos < 0) {
                        result[i] = person;
                        break;
                    }
                }
            }

            return result;

        }
    }

    public static void show(int[][] people) {
        show(people, null);
    }

    public static void show(int[][] people, String result) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] person : people) {
            if (person == null) {
                sb.append("null,");
                continue;
            }
            sb.append("[")
                    .append(person[0])
                    .append(",")
                    .append(person[1])
                    .append("],");
        }
        sb.append("]");
        System.out.println(sb.toString());
        if (result != null) {
            System.out.println(result);
        }
    }
}
