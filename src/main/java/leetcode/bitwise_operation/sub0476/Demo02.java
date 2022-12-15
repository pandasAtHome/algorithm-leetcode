package leetcode.bitwise_operation.sub0476;

public class Demo02 {
    public static void main(String[] args) {
        Solution solution = new Demo02().new Solution();
//        System.out.println(solution.findComplement(5) + " = 2");
//        System.out.println(solution.findComplement(1) + " = 0");
        for (int i = 1; i < 21; i++) {
            System.out.println(Integer.toBinaryString(i) + " " + solution.findComplement(i));
        }
    }

    class Solution {
        public int findComplement(int num) {
            int i = 0;
            int result = 0;
            while (num != 0) {
                if ((num & 1) == 0) {
                    result |= (1 << i);
                }
                num >>= 1;
                i++;
            }
            return result;
        }
    }
}
