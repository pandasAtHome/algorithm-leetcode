package leetcode.data_structure.sub0218;

import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
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
            // 1、获取所有建筑物的横向坐标，并从小到大排序
            ArrayList<Integer> positions = new ArrayList<>();
            for (int[] building : buildings) {
                // 左坐标
                positions.add(building[0]);
                // 右坐标
                positions.add(building[1]);
            }
            Collections.sort(positions);

            // 2、创建一个优先队列 <横向坐标, 高度>，排序规则为 按高度倒序
            PriorityQueue<int[]> maxHeightHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            List<List<Integer>> result = new ArrayList<>();
            int idx = 0, n = buildings.length;
            List<Integer> lastPoint = Arrays.asList(0, 0);
            for (Integer position : positions) {
                while (idx < n && buildings[idx][0] <= position) {
                    maxHeightHeap.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                    idx++;
                }
                while (!maxHeightHeap.isEmpty() && maxHeightHeap.peek()[0] <= position) {
                    maxHeightHeap.poll();
                }
                int maxHeight = maxHeightHeap.isEmpty() ? 0 : maxHeightHeap.peek()[1];
                if (maxHeight != lastPoint.get(1)) {
                    lastPoint = Arrays.asList(position, maxHeight);
                    result.add(lastPoint);
                }

            }

            return result;
        }
    }
}
