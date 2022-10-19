package leetcode.first_search.sub0257;

import java.util.*;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        List<Integer> list = Arrays.asList(1, 2, 3, null, 5);
        TreeNode tree = listToTree(list);
        System.out.println(solution.binaryTreePaths(tree));
//        System.out.println(treeToList(tree));
    }

    class Solution {
        List<String> result;
        public List<String> binaryTreePaths(TreeNode root) {
            result = new ArrayList<>();
            // 1、定义一个路径列表
            /* ----- 空间 O(L) ----- */
            Deque<Integer> path = new LinkedList<>();
            // 2、穷举所有的路径
            /* +++++ 遍历树节点：时间 O(n) +++++ */
            /* ----- 栈空间：空间 O(n) ----- */
            backtrack(root, path);
            return result;
        }

        private void backtrack(TreeNode root, Deque<Integer> path) {
            if (root == null) {
                return;
            }
            // 3、添加节点值
            path.add(root.val);
            if (root.left == null && root.right == null) {
                // 4.1、找到叶子节点，记录路径
                StringBuilder sb = new StringBuilder();
                for (Integer num : path) {
                    // 细节问题1：`->` 放在头部，最后直接删除前两个字符
                    sb.append("->").append(num);
                }
                sb.delete(0, 2);
                result.add(sb.toString());
            } else {
                // 4.2、继续寻找叶子节点
                backtrack(root.left, path);
                backtrack(root.right, path);
            }
            // 5、回溯
            path.removeLast();
        }
    }

    private static TreeNode listToTree(List<Integer> list) {
        int n = list.size();
        int pos = 0;
        TreeNode root = new TreeNode(list.get(pos++));
        if (n == 1) {
            return root;
        }
        getSons(root, list, n, pos);
        return root;
    }

    private static int getSons(TreeNode root, List<Integer> list, int n, int pos) {
        if (root == null || pos == n) {
            return pos;
        }
        TreeNode leftNode, rightNode;
        Integer left = list.get(pos++);
        leftNode = left == null ? null : new TreeNode(left);
        root.left = leftNode;
        if (pos == n) {
            return pos;
        }
        Integer right = list.get(pos++);
        rightNode = right == null ? null : new TreeNode(right);
        root.right = rightNode;
        if (pos == n) {
            return pos;
        }
        pos = getSons(leftNode, list, n, pos);

        return getSons(rightNode, list, n, pos);
    }

    private static List<Integer> treeToList(TreeNode tree) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(tree);
        TreeNode node;
        while (!nodes.isEmpty()) {
            node = nodes.poll();
            if (node == null) {
                list.add(null);
                continue;
            }
            list.add(node.val);
            if (node.right == null && node.left == null) {
                continue;
            }
            nodes.add(node.left);
            nodes.add(node.right);
        }
        return list;
    }
}
