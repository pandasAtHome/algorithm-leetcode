package sort;

import java.util.Arrays;

/** 冒泡排序
 * - 步骤：
 *      - 比较相邻的两个元素，若前者 大于 后者，交换位置，直至把未排序序列中的最大者 放到 当前队伍末尾
 *      - 每次比较完一轮，需排序的集合长度 -1
 */
public class BubbleSort implements ISort {
    public static void main(String[] args) {
        ISort sortModel = new BubbleSort();
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
        int temp;
        for (int i = 1; i < n; i++) {
            // 是否有交换位置操作
            boolean exchange = false;
            // 每次比较完一轮，需排序的集合长度 -1
            for (int j = 0; j < n - i; j++) {
                // 比较相邻的两个元素，若前者 大于 后者，交换位置，直至把未排序序列中的最大者 放到 当前队伍末尾
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    exchange = true;
                }
            }
            // 没有交换操作，提前退出循环
            if (!exchange) {
                break;
            }
        }
    }
}
