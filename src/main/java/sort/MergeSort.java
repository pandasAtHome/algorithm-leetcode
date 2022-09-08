package sort;

import java.util.Arrays;

/** 归并排序
 * - 步骤
 *      - 分割：递归地将当前序列平均分成两部分
 *      - 集成：在保持元素顺序的同时，将上一步得到子序列集成到一块
 */
public class MergeSort implements ISort {
    public static void main(String[] args) {
        ISort sortModel = new MergeSort();
        int[] array = {3, 1, 9, 5, 1, 6, 2, 8, 4, 7, 0};
        System.out.println(Arrays.toString(array));
        sortModel.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void sort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        // 创建一个空间，用于存放 两个子序列 排序后的结果
        int[] result = new int[n];
        mergeSort(array, result, 0, n - 1);
    }

    private void mergeSort(int[] array, int[] result, int left, int right) {
        if (left >= right) {
            // 已经是最小的分区了
            return;
        }
        // 1、分割：递归地将当前序列平均分成两部分
        int mid = (left + right) / 2;
        // 左分区范围：[left_start, left_end]
        int left_start = left, left_end = mid;
        // 右分区范围：[right_start, right_end]
        int right_start = mid + 1, right_end = right;
        mergeSort(array, result, left_start, left_end);
        mergeSort(array, result, right_start, right_end);

        int i = left;
        // 2、集成：在保持元素顺序的同时，将上一步得到子序列集成到一块
        // 2.1、对左右分区进行排序，并合并成一个 `新序列` (非递减序列)
        while (left_start <= left_end && right_start <= right_end) {
            result[i++] = array[left_start] <= array[right_start]
                    ? array[left_start++]
                    : array[right_start++];
        }
        // 2.2、把左分区剩余的元素加入到新序列中
        while (left_start <= left_end) {
            result[i++] = array[left_start++];
        }
        // 2.3、把分区剩余的元素加入到新序列中
        while (right_start <= right_end) {
            result[i++] = array[right_start++];
        }

        // 3、把排好序的序列同步到 `主空间`
        for (i = left; i <= right; i++) {
            array[i] = result[i];
        }
    }
}
