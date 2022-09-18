package leetcode.sub0547;

public class Demo01 {
    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
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
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int n = isConnected.length;
            // 当前省份的数量
            int provinces = 0;
            // 1、定义一个浏览记录列表
            /* ----- 空间 O(n) ----- */
            boolean[] visited = new boolean[n];
            // 2、遍历所有城市（遍历矩阵的纵向）
            /* +++++ 时间 O(n) +++++ */
            for (int i = 0; i < n; i++) {
                // 3、若当前城市未检索，标记出属于同一省份的所有城市
                if (!visited[i]) {
                    // 找出属于同一个省份的城市
                    /* +++++ 时间 O(n) +++++ */
                    dfs(isConnected, visited, i);
                    // 省份数 +1
                    provinces++;
                }
            }
            return provinces;
        }

        private void dfs(int[][] isConnected, boolean[] visited, int i) {
            // 标记为：已检索
            visited[i] = true;
            // 遍历矩阵的横向
            for (int j = 0; j < isConnected.length; j++) {
                // 找出与当前城市直接连通的城市
                if (isConnected[i][j] == 1 && !visited[j]) {
                    dfs(isConnected, visited, j);
                }
            }
        }
    }
}
