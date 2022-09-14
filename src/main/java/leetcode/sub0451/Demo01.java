package leetcode.sub0451;

import java.util.*;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree") + " = eert");
        System.out.println(solution.frequencySort("cccaaa") + " = cccaaa");
        System.out.println(solution.frequencySort("Aabb") + " = bbAa");
    }

    public static void show(int[][] array) {
        for (int[] nums : array) {
            System.out.print(Arrays.toString(nums) + ", ");
            System.out.println();
        }
    }

    static class Solution {
        public String frequencySort(String s) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            // 1、统计词频
            int n = s.length();
            char ch;
            /* ----- 统计词频：空间 O(n) ----- */
            /* +++++ 统计词频：时间 O(n) +++++ */
            Map<Character, Integer> charAndCnt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                ch = s.charAt(i);
                charAndCnt.put(ch, charAndCnt.getOrDefault(ch, 0) + 1);
            }
            // 2、细节问题1：没有重复字符
            int m = charAndCnt.size();
            if (n == m) {
                return s;
            }
            // 3、细节问题2：转换为数组，方便排序时，交换位置
            /* ----- map转数组：空间 O(m) ----- */
            /* +++++ map转数组：时间 O(m) +++++ */
            int[][] wordCount = new int[m][2];
            int i = 0;
            for (Map.Entry<Character, Integer> entry : charAndCnt.entrySet()) {
                wordCount[i++] = new int[]{entry.getKey(), entry.getValue()};
            }
            // 4、按词频倒序
            /* ----- 快排：空间 O(log m) ----- */
            /* +++++ 快排：时间 O(m log m) +++++ */
            quickSort(wordCount, 0, m - 1);
            // 5、拼接字符，输出
            StringBuilder sb = new StringBuilder();
            for (int[] info : wordCount) {
                // 5.1、n 个相同的字符
                for (i = 0; i < info[1]; i++) {
                    sb.append((char) info[0]);
                }
            }
            return sb.toString();
        }

        private void quickSort(int[][] array, int left, int right) {
            if (left < right) {
                // 4.1、分区：词频高的在前面
                int mid = partition(array, left, right);
                // 4.2、词频为1，不再加入排序
                if (array[mid][1] == 1) {
                    // 词频为1，压缩左分区范围
                    mid--;
                } else {
                    // 4.3、对于右分区：只有 mid 词频大于1才排序
                    quickSort(array, mid + 1, right);
                }
                // 4.4、对左分区的高词频字符排序
                quickSort(array, left, mid);
            }
        }

        private int partition(int[][] array, int left, int right) {
            int pivot = array[left][1];
            int index = left + 1;
            for (int i = index; i <= right; i++) {
                if (array[i][1] > pivot) {
                    swap(array, i, index++);
                }
            }
            swap(array, left, --index);
            return index;
        }

        private void swap(int[][] array, int left, int right) {
            // 禁止原地交换
            if (left == right) {
                return;
            }
            int[] temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }

    }

    static class Solution2 {
        public String frequencySort(String s) {
            Map<Character, Integer> charAndCnt = new HashMap<>();
            int n = s.length();
            int frequency;
            char ch;
            for (int i = 0; i < n; i++) {
                ch = s.charAt(i);
                frequency = charAndCnt.getOrDefault(ch, 0) + 1;
                charAndCnt.put(ch, frequency);
            }
            List<Character>[] buckets = new List[n + 1];
            for (Map.Entry<Character, Integer> entry : charAndCnt.entrySet()) {
                frequency = entry.getValue();
                if (buckets[frequency] == null) {
                    buckets[frequency] = new ArrayList<>();
                }
                buckets[frequency].add(entry.getKey());
            }

            StringBuilder sb = new StringBuilder();
            for (frequency = n; frequency > 0; frequency--) {
                if (buckets[frequency] == null) {
                    continue;
                }
                // 此词频的字符
                List<Character> bucket = buckets[frequency];
                for (Character character : bucket) {
                    for (int k = 0; k < frequency; k++) {
                        sb.append(character);
                    }
                }
            }

            return sb.toString();
        }

    }
}
