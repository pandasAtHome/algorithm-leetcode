package sort;

import java.util.Arrays;

/** 插入排序
 * - 步骤：
 *      - 抽取第一个元素，放入手牌(已排好序的序列)
 *      - 从左往右抽牌（从第二个元素开始）
 *      - 每抽一张牌(新牌)，在手牌中从右往左扫描
 *      - 如果当前扫描的手牌 大于 新牌
 *          - 当前扫描的手牌 向后移动一位
 *          - 直到找出 小于等于 新牌 的位置，插入新牌
 */
public class InsertionSort implements ISort {
    public static void main(String[] args) {
        ISort sortModel = new InsertionSort();
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
        // 1、抽取第一个元素，放入手牌(已排好序的序列)
        // 2、从左往右抽牌（从第二个元素开始）
        int newKey;  // 新牌
        for (int i = 1; i < n; i++) {
            // 3、每抽一张牌(新牌)，在手牌中从右往左扫描
            newKey = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] <= newKey) {
                    break;
                }
                // 3.1、如果当前扫描的手牌 大于 新牌，当前扫描的手牌 向后移动一位
                array[j + 1] = array[j];
            }
            // 3.2、直到找出 小于等于 新牌 的位置，插入新牌
            array[j + 1] = newKey;
        }
    }
}
