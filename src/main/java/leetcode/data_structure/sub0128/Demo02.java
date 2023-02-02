package leetcode.data_structure.sub0128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100,4,200,1,3,2}) + " = 4");
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}) + " = 9");
    }

    class Solution {
        public int longestConsecutive(int[] nums) {
            UnionFind unionFind = new UnionFind(nums);
            int maxConnectNum = 0;
            for (int num : nums) {
                if (unionFind.find(num + 1) != null) {
                    unionFind.union(num, num + 1);
                }
            }
            for (int num : nums) {
                maxConnectNum = Math.max(maxConnectNum, unionFind.find(num) - num + 1);
            }

            return maxConnectNum;
        }
    }

    class UnionFind {
        Map<Integer, Integer> parent;
        UnionFind(int[] nums) {
            parent = new HashMap<>();
            for (int num : nums) {
                parent.put(num, num);
            }
        }

        Integer find(Integer num) {
            if (!parent.containsKey(num)) {
                return null;
            }
            while (!parent.get(num).equals(num)) {
                Integer oldParent = parent.get(num);
                parent.put(num, parent.get(oldParent));
                num = oldParent;
            }
            return num;
        }

        void union(int numA, int numB) {
            int rootA = find(numA);
            int rootB = find(numB);
            if (rootA != rootB) {
                parent.put(rootA, rootB);
            }
        }
    }

}
