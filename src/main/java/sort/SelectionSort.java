package sort;

import java.util.Arrays;

/** 选择排序
 * - 步骤：
 *      - 在未排序的序列中，找出最小的元素，放到排序序列的起始位置
 *      - 再从剩余未排序的序列中，找出最小的元素位置
 *      - 把未排序序列中的最小元素，放到已排好序的序列末尾
 */
public class SelectionSort implements ISort {
    public static void main(String[] args) {
        ISort sortModel = new SelectionSort();
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

        // 未排序序列中最小元素的位置
        int minIdx;
        int temp;
        // 1、在未排序的序列中，找出最小的元素，放到排序序列的起始位置
        for (int i = 0; i < n; i++) {
            minIdx = i;
            // 2、再从剩余未排序的序列中，找出最小的元素位置
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            // 3、把未排序序列中的最小元素，放到已排好序的序列末尾
            if (minIdx != i) {
                temp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = temp;
            }
        }
    }
}
