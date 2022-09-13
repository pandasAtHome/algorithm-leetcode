package leetcode.sub0347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,1,1,2,2,3,4,5}, 2)) + " = [1,2]");
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            /* ----- hash表 & 数组：空间 2 * O(n) ----- */
            /* +++++ 遍历数组 & hash表转数组：时间 2 * O(n) +++++ */
            // 1、统计每个次出现的次数：{{'元素1', '出现频率'}, {'元素2', '出现频率'}, ...}
            int[][] numAndCnt = wordCount(nums);
            int n = numAndCnt.length;
            // 2、细节问题1：`不同元素个数 = k`，直接返回
            if (n == k) {
                return getTopK(numAndCnt, k);
            }

            // 3、快速查找：按照词频倒序（并不需要真正的排序，只要获取出现频率最高的前k个即可）
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int left = 0, right = n - 1, mid;
            /* ----- 快速查找：空间 O(log n) ----- */
            /* +++++ 快速查找：时间 O(2n) +++++ */
            while (left < right) {
                mid = partition(numAndCnt, left, right);
                if (mid == k) {
                    return getTopK(numAndCnt, mid);
                } else if (mid > k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 4、返回出现频率最高的前k个元素
            return getTopK(numAndCnt, left);
        }

        // 元素出现次数统计
        private int[][] wordCount(int[] nums) {
            HashMap<Integer, Integer> numAndCnt = new HashMap<>();
            for (int num : nums) {
                numAndCnt.put(num, numAndCnt.getOrDefault(num, 0) + 1);
            }
            int[][] result = new int[numAndCnt.size()][2];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : numAndCnt.entrySet()) {
                result[i++] = new int[]{entry.getKey(), entry.getValue()};
            }

            return result;
        }

        // 分区：出现频率较高的元素排在前面
        private int partition(int[][] numAndCnt, int left, int right) {
            int pivot = numAndCnt[left][1];
            int index = left + 1;
            for (int i = index; i <= right; i++) {
                if (numAndCnt[i][1] > pivot) {
                    swap(numAndCnt, i, index++);
                }
            }
            swap(numAndCnt, left, --index);
            return index;
        }

        // 交换元素
        private void swap(int[][] numAndCnt, int left, int right) {
            int[] temp = numAndCnt[left];
            numAndCnt[left] = numAndCnt[right];
            numAndCnt[right] = temp;
        }

        /**
         * 返回词频最高的前 k 个元素
         * @param numAndCnt 词频序列
         * @param k 前 k 个
         * @return 出现频率最高的前 k 个元素
         */
        private int[] getTopK(int[][] numAndCnt, int k) {
            int[] result = new int[k];

            for (int i = 0; i < k; i++) {
                result[i] = numAndCnt[i][0];
            }
            return result;
        }
    }
}
