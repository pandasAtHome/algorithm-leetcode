package leetcode.double_pointer.sub0680;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.validPalindrome("aba") + " = true");
        System.out.println(solution.validPalindrome("abca") + " = true");
        System.out.println(solution.validPalindrome("abc") + " = false");
    }

    // 效率较高
    class Solution {
        public boolean validPalindrome(String s) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int n = s.length();
            // 1、细节问题1：`1 <= s.length() <= 2`，是回文
            if (n <= 2) {
                return true;
            }
            // 2、细节问题2：可能需要多次获取字符串中某个位置的字符，所以转换为字符数组
            /* ----- 字符串转字符数组：空间 O(n) ----- */
            /* ----- 字符串转字符数组：时间 O(n) ----- */
            char[] chars = s.toCharArray();
            // 3、定义一对首尾指针，夹逼搜索
            int left = 0, right = n - 1;
            /* ----- 数组遍历：时间 O(n) ----- */
            while (left <= right) {
                // 3.1、相等，首尾指针向中间移动
                /* ----- 回文判断 & 获取字符：时间 O(3n) ----- */
                /* ----- 挪动指针：时间 O(2n) ----- */
                if (chars[left] == chars[right]) {
                    left++;
                    right--;
                } else {
                    /* 3.2、不等
                     *  - 假设左边删除一个元素，是为回文，返回true，否则：
                     *  - 假设右边删除一个元素，判断是否为回文，返回结果
                     */
                    return isPalindrome(chars, left + 1, right) || isPalindrome(chars, left, right - 1);
                }
            }
            return true;
        }

        // 回文判断：删除字符后
        protected boolean isPalindrome(char[] chars, int left, int right) {
            while (left <= right) {
                /* 由于已删除字符，所以存在不相等时，即可判断为不是回文
                 *  - 调用方法时，已移动 left or right
                 */
                if (chars[left++] != chars[right--]) {
                    return false;
                }
            }
            return true;
        }
    }

    // 效率较差
    class Solution2 {
        public boolean validPalindrome(String s) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int n = s.length();
            // 1、细节问题1：`1 <= s.length() <= 2`，是回文
            if (n <= 2) {
                return true;
            }
            // 2、定义一对首尾指针，夹逼搜索
            int left = 0, right = n - 1;
            /* ----- 数组遍历：时间 O(n) ----- */
            while (left <= right) {
                // 2.1、相等，首尾指针向中间移动
                /* ----- 回文判断：时间 O(n) ----- */
                /* ----- 获取字符：时间 O(3n) ----- */
                /* ----- 挪动指针：时间 O(2n) ----- */
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    /* 2.2、不等
                     *  - 假设左边删除一个元素，是为回文，返回true，否则：
                     *  - 假设右边删除一个元素，判断是否为回文，返回结果
                     */
                    return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
                }
            }
            return true;
        }

        // 回文判断：删除字符后
        protected boolean isPalindrome(String s, int left, int right) {
            while (left <= right) {
                /* 由于已删除字符，所以存在不相等时，即可判断为不是回文
                 *  - 调用方法时，已移动 left or right
                 */
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
