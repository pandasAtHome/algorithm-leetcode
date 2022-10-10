package utils;

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
}
