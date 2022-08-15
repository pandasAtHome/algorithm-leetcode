package leetcode.sub0605;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{0}, 1) + " = true");
        System.out.println(solution.canPlaceFlowers(new int[]{0, 0, 1}, 1) + " = true");
        System.out.println(solution.canPlaceFlowers(new int[]{0, 1, 1}, 1) + " = false");
        System.out.println(solution.canPlaceFlowers(new int[]{1}, 0) + " = true");
        System.out.println(solution.canPlaceFlowers(new int[]{0, 1, 0}, 1) + " = false");
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1) + " = true");
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2) + " = false");
        System.out.println(solution.canPlaceFlowers(new int[]{1, 1, 0, 0, 1, 1}, 1) + " = false");
        System.out.println(solution.canPlaceFlowers(new int[]{0, 0, 0, 0, 0}, 3) + " = true");
    }

    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            // 1、边界问题：无需种植
            if (n == 0) {
                return true;
            }
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            // 花坛长度
            int flowerbedLen = flowerbed.length;
            // 上一个种植了花的位置
            int prev = -1;
            /* +++++ 遍历数组：时间 O(3n) +++++ */
            for (int i = 0; i < flowerbedLen; i++) {
                // 最左侧：left = prev + 1
                // 最右侧：right = i - 1
                // 2、寻找已经种了花的位置
                /* +++++ N次较大者判断：时间 O(n) +++++ */
                if (flowerbed[i] == 1) {
                    // 3、计算可种植数量
                    if (prev < 0) {
                        // 3.1、之前都没种过花
                        //   => left可种植，right不可种植
                        // 可种植数量：
                        //   => numOfPlant = (i - prev - 1) / 2,  prev = -1
                        //   => numOfPlant = i / 2
                        // 举例：
                        //   [0, 0, 1, ...]  =>  可种植 1朵
                        //   [0, 1, 1, ...]  =>  不可种植
                        n -= (i / 2);
                    } else {
                        // 3.2、之前有种过花
                        //   => left & right 均不可种植
                        // 可种植数量：
                        //   => numOfPlant = (i - prev - 2) / 2
                        // 举例：
                        //   [1, 0, 0, 0, 1, ...]  =>  可种植 1朵
                        //   [1, 0, 0, 1, 1, ...]  =>  不可种植
                        n -= ((i - prev - 2) / 2);
                    }
                    // 4、边界问题：已经没有了需要种植的花
                    if (n <= 0) {
                        return true;
                    }
                    // 5、记录当前种了花的位置
                    prev = i;
                }
            }

            // 6、仍然有需要种植的花
            if (prev < 0) {
                // 6.1、所有位置均可种植
                // 举例：
                //   [0]  =>  可种植 1朵
                n -= (flowerbedLen + 1) / 2;
            } else {
                // 6.2、剩余可种植位置数量
                // 举例：
                //   [0, 1, 0, 0, 0]  =>  可种植 1朵
                n -= (flowerbedLen - prev - 1) / 2;
            }

            return n <= 0;
        }
    }
}
