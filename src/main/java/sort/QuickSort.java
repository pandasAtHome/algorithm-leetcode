package sort;

import java.util.Arrays;

/** 快速排序
 * - 步骤
 *      - 挑选基准值：
 *          - 从数列中挑选一个元素作为基准(pivot)
 *      - 分区：
 *          - 左区间：比基准值小的元素
 *          - 右区间：比基准值大的元素
 *      - 递归排序子序列：
 *          - 递归地将 `左区间` 和 `右区间` 进行排序
 */
public class QuickSort implements ISort {
    public static void main(String[] args) {
        ISort sortModel = new QuickSort();
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
        quickSort(array, 0, n - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // 1、分区
            int mid = partition(array, left, right);
            // 2、递归的将 `左分区` 进行排序
            quickSort(array, left, mid);
            // 3、递归的将 `右分区` 进行排序
            quickSort(array, mid + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        // 1、挑选基准值：
        int pivot = array[left];
        // 2、分区：
        while (left < right) {
            // 2.1、划分右分区：找出 大于等于 基准值的元素
            while (left < right && array[right] >= pivot) {
                --right;
            }
            // 2.2、分区完毕
            if (left >= right) {
                break;
            }
            // 2.3、把较小者移到左分区，同时使左指针移动一步
            array[left++] = array[right];
            // 2.4、划分左分区：找出 小于等于 基准值的元素
            while (left < right && array[left] <= pivot) {
                ++left;
            }
            // 2.5、把较大者移到右分区，同时使右指针移动一步
            array[right--] = array[left];
        }
        // 3、移动基准值到中间，并返回分界线位置
        array[left] = pivot;
        return left;
    }
}
