package leetcode.first_search.sub0310;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Demo03 {
    public static void main(String[] args) {
        Solution solution = new Demo03().new Solution();
//        System.out.println(solution.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
//        System.out.println(solution.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
        System.out.println(solution.findMinHeightTrees(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}}));
    }

    class Solution {
        // 结果集
        List<Integer> result;
        // 图
        List<List<Integer>> graph;
        // 每个节点的度（最小度 = 1，即 叶子节点）
        int[] inDegree;

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            result = new ArrayList<>();
            inDegree = new int[n];
            graph = new ArrayList<>();
            // 1、构建图 & 记录每个节点的度
            buildGraphAndGetDegree(edges, n);
            // 2、找出所有的叶子节点
            Deque<Integer> queue = getLeafNode(n);
            // 3、剪枝 & 找出中间节点
            lopAndFindMiddleNode(queue, n);
            if (queue.isEmpty()) {
                result.add(0);
            } else {
                result = new ArrayList<>(queue);
            }

            return result;
        }

        private void buildGraphAndGetDegree(int[][] edges, int n) {
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                // 构建双向联系
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
                // 记录各节点的度
                inDegree[edge[0]]++;
                inDegree[edge[1]]++;
            }
        }

        private Deque<Integer> getLeafNode(int n) {
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 1) {
                    // 获取 度 = 1 的 叶子节点
                    queue.offer(i);
                }
            }
            return queue;
        }

        private void lopAndFindMiddleNode(Deque<Integer> queue, int n) {
            int size;
            Integer curNode;
            /**
             * 由于操作的对象是树，只存在以下两种连接情况：
             *  - 两个节点相连：
             *      - (根节点 - 子节点)、(根节点 - 叶子节点)、(子节点 - 子节点)、(子节点 - 叶子节点)
             *  - 单个节点：只有 根节点
             * 故：
             *  - 最后 `度 == 1` 的节点数量 <= 2
             */
            while (n > 2) {
                size = queue.size();
                n -= size;
                for (int i = 0; i < size; i++) {
                    // 出队：（旧）叶子节点
                    curNode = queue.poll();
                    for (Integer parentNode : graph.get(curNode)) {
                        if (--inDegree[parentNode] == 1) {
                            // 入队：（新）叶子节点
                            queue.offer(parentNode);
                        }
                    }
                }
            }
        }
    }
}
