package leetcode.first_search.sub0257;

import java.util.*;

public class Demo02 {

    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        List<Integer> list = Arrays.asList(1, 2, 3, null, 5);
        TreeNode tree = listToTree(list);
        System.out.println(solution.binaryTreePaths(tree));
//        System.out.println(treeToList(tree));
    }

    class Solution {
        List<String> result;
        public List<String> binaryTreePaths(TreeNode root) {
            result = new ArrayList<>();
            dfs(root, "");
            return result;
        }

        private void dfs(TreeNode root, String path) {
            if (root == null) {
                return;
            }
            StringBuilder pathSb = new StringBuilder(path);
            pathSb.append(root.val);
            if (root.left == null && root.right == null) {
                // 找到叶子节点，记录路径
                result.add(pathSb.toString());
            } else {
                // 继续寻找路径
                pathSb.append("->");
                path = pathSb.toString();
                dfs(root.left, path);
                dfs(root.right, path);
            }
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
