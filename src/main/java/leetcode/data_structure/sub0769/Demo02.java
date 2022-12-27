package leetcode.data_structure.sub0769;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
        System.out.println(solution.maxChunksToSorted(new int[]{4,3,2,1,0}) + " = 1");
        System.out.println(solution.maxChunksToSorted(new int[]{1,0,2,3,4}) + " = 4");
    }

    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length;
            int res = 0, maxVal = 0;
            for (int i = 0; i < n; i++) {
                maxVal = Math.max(maxVal, arr[i]);
                if (maxVal == i) {
                    res++;
                }
            }
            return res;
        }
    }
}
