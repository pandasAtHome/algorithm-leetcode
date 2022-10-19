package leetcode.first_search.sub0547;

import java.util.HashMap;
import java.util.Map;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        int[][] isConnected;
        isConnected = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected) + " = 2");
        isConnected = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected) + " = 3");
        isConnected = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(solution.findCircleNum(isConnected) + " = 1");
    }

    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            MergeFindSet<Integer> ufs = new MergeFindSet<>();
            for (int i = 0; i < n; i++) {
                ufs.insert(i);
                for (int j = 0; j < i; j++) {
                    if (isConnected[i][j] == 1) {
                        ufs.merge(i, j);
                    }
                }
            }
            return ufs.getNumOfNode();
        }

        /**
         * 并查集：
         *  - 并：合并
         *  - 查：查找
         *  - 集：一个字典集合，存储的是 `该节点` 与 `其父节点`
         * @param <E>
         */
        class MergeFindSet<E> {
            private final Map<E, E> parent;
            private int numOfNode = 0;

            MergeFindSet() {
                parent = new HashMap<>();
            }

            /**
             * 增加新节点
             *  - 默认的父级为 null
             * @param node 新节点
             */
            public void insert(E node) {
                if (!parent.containsKey(node)) {
                    parent.put(node, null);
                    numOfNode++;
                }
            }

            /**
             * 合并两个节点
             * @param node1 子节点1
             * @param node2 子节点2
             */
            public void merge(E node1, E node2) {
                E root1 = find(node1);
                E root2 = find(node2);
                if (root1 != root2) {
                    parent.put(root1, root2);
                    numOfNode--;
                }
            }

            /**
             * 获取父节点 & 缩短子节点查找到父节点的路径长度
             * @param node 子节点
             * @return E
             */
            public E find(E node) {
                E root = node;
                // 查找父节点
                // 复杂度：O(n)
                while (parent.get(root) != null) {
                    root = parent.get(root);
                }

                /* 缩短子节点查找到父节点的路径长度
                 *  - 复杂度：O(n) => O(1)
                 *      - O(n)：原来查询顶级父节点的复杂度
                 *          - 5 -> 4 -> 3 -> 2 -> 1
                 *      - O(1)：下次查询顶级父节点的复杂度
                 *          - 5 -> 1
                 *          - 4 -> 1
                 *          - 3 -> 1
                 *          - 2 -> 1
                 */
                while (node != root) {
                    E oldParent = parent.get(node);
                    parent.put(node, root);
                    node = oldParent;
                }

                return root;
            }

            public int getNumOfNode() {
                return numOfNode;
            }
        }

    }
}
