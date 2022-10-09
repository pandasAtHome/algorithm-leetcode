package leetcode.sub0310;

import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        /**
         * 0 -- 1 -- 2
         *      |
         *      3
         */
        System.out.println(solution.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        /**
         * 0 \
         * 1 -- 3 -- 4 -- 5
         * 2 /
         */
        System.out.println(solution.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
        /**
         * 1 \
         *    0 -- 3 -- 4 -- 5
         * 2 /
         */
        System.out.println(solution.findMinHeightTrees(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}}));
    }

    class Solution {
        // 结果集
        List<Integer> result;
        // 图
        List<List<Integer>> graph;
        // 父节点
        int[] parent;

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            result = new ArrayList<>();
            graph = new ArrayList<>();
            parent = new int[n];
            // 1、连接节点，构建关系图 & 初始化各节点的父节点
            /* ----- 空间 O(n) ----- */
            /* +++++ 时间 O(n) +++++ */
            buildGraphAndInitParent(edges, n);
            // 2、寻找距离 0 最远的节点 x & 确定各节点的父节点
            /* ----- 空间 O(n) ----- */
            /* +++++ 时间 O(n) +++++ */
            int x = findLongestNode(0, n);
            // 3、寻找距离 x 最远的节点 y & 确定各节点的父节点
            /* ----- 空间 O(n) ----- */
            /* +++++ 时间 O(n) +++++ */
            int y = findLongestNode(x, n);
            // 4、获取最长路径
            /* ----- 空间 O(n) ----- */
            /* +++++ 时间 O(n) +++++ */
            List<Integer> longestPath = getLongestPath(x, y);
            // 5、找出中位值
            int m = longestPath.size();
            if (m % 2 == 0) {
                result.add(longestPath.get(m / 2 - 1));
            }
            result.add(longestPath.get(m / 2));

            return result;
        }

        private void buildGraphAndInitParent(int[][] edges, int n) {
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
                parent[i] = -1;
            }
            for (int[] edge : edges) {
                // 构建双向联系
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
        }

        private int findLongestNode(int node, int n) {
            boolean[] used = new boolean[n];
            used[node] = true;
            Deque<Integer> queue = new LinkedList<>();
            queue.offer(node);
            node = -1;
            while (!queue.isEmpty()) {
                node = queue.poll();
                for (Integer childNode : graph.get(node)) {
                    if (used[childNode]) {
                        continue;
                    }
                    // 设置父节点
                    parent[childNode] = node;
                    used[childNode] = true;
                    queue.offer(childNode);
                }
            }
            return node;
        }

        private List<Integer> getLongestPath(int x, int y) {
            List<Integer> path = new ArrayList<>();
            parent[x] = -1;
            while (y != -1) {
                path.add(y);
                y = parent[y];
            }
            return path;
        }

    }
}
