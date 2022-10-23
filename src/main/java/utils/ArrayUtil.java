package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ArrayUtil {

    // 显示 Map 结果
    public static <K, V> void showMap(Map<K, V> array) {
        for (Map.Entry<K, V> entry : array.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // 显示 二维list 类型
    public static <E> void showList(List<E> array) {
        for (E ele : array) {
            System.out.println(ele);
        }
    }

    public static void showArray(int[][] array) {
        for (int[] ele : array) {
            System.out.println(Arrays.toString(ele));
        }
    }

    public static void showArray(boolean[][] array) {
        for (boolean[] ele : array) {
            System.out.println(Arrays.toString(ele));
        }
    }

    public static void showArray(double[][] array) {
        for (double[] ele : array) {
            System.out.println(Arrays.toString(ele));
        }
    }

    public static void showArray(float[][] array) {
        for (float[] ele : array) {
            System.out.println(Arrays.toString(ele));
        }
    }

    public static void showArray(char[][] array) {
        for (char[] ele : array) {
            System.out.println(Arrays.toString(ele));
        }
    }

    public static <E> void showArray(E[][] array) {
        for (E[] ele : array) {
            System.out.println(Arrays.toString(ele));
        }
    }
}
