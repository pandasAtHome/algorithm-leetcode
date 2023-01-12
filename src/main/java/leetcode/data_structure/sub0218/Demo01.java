package leetcode.data_structure.sub0218;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        int[][] buildings;
        buildings = new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        System.out.println(solution.getSkyline(buildings));
        System.out.println("[[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]");
        buildings = new int[][]{
                {0, 2, 3},
                {2, 5, 3}
        };
        System.out.println(solution.getSkyline(buildings));
        System.out.println("[[0, 3], [5, 0]]");
    }

    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            // 1、创建一个优先队列 `<右横向坐标, 高度>`，排序规则为 按高度倒序
            PriorityQueue<int[]> maxHeightHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            List<List<Integer>> result = new ArrayList<>();
            int idx = 0, n = buildings.length, curX, curH;
            // 2、记录上一个轮廓节点，从 (0, 0) 开始
            List<Integer> prevPoint = Arrays.asList(0, 0);
            while (idx < n || !maxHeightHeap.isEmpty()) {
                // 3、空队列 or 当前建筑的左横坐标 <= 最高建筑的右横坐标
                if (maxHeightHeap.isEmpty() || (idx < n && buildings[idx][0] <= maxHeightHeap.peek()[0])) {
                    curX = buildings[idx][0];
                    // 当前横坐标为 下一个建筑的 左横坐标
                    while (idx < n && curX == buildings[idx][0]) {
                        // 入队
                        maxHeightHeap.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                        // 当前建筑指针 指向下一个建筑
                        idx++;
                    }
                } else {
                    // 获取队列中，最高的建筑的 右横坐标
                    curX = maxHeightHeap.peek()[0];
                    // 4、移除已扫描完的左边的建筑
                    while (!maxHeightHeap.isEmpty() && curX >= maxHeightHeap.peek()[0]) {
                        maxHeightHeap.poll();
                    }
                }
                // 5、记录天际线轮廓点
                // 获取 最高建筑的高度
                curH = maxHeightHeap.isEmpty() ? 0 : maxHeightHeap.peek()[1];
                // 与前一个轮廓节点 不在同一个高度，记录新的轮廓点
                if (result.isEmpty() || curH != prevPoint.get(1)) {
                    prevPoint = Arrays.asList(curX, curH);
                    result.add(prevPoint);
                }
            }

            return result;
        }
    }
}
