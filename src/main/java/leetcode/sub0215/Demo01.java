package leetcode.sub0215;

public class Demo01 {

    public static void main(String[] args) {
        Solution solution = new Demo01().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2) + " = 5");
        System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4) + " = 4");
    }

    /**
     * 	执行耗时:16 ms,击败了44.99% 的Java用户
     * 	内存消耗:49 MB,击败了34.48% 的Java用户
     */
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int n = nums.length;
            int left = 0, right = n - 1, target = n - k, mid;
            /* +++++ 二分查找：时间 O(log n) +++++ */
            while (left < right) {
                // 1、利用快排的分区思想，找出 pivot 所在位置，跟 目标位置target 比较
                /* +++++ 分区：时间 O(n) +++++ */
                /* ----- 定义了一堆数值变量：空间 O(1) ----- */
                mid = partition(nums, left, right);
                /* +++++ 比较 & 移动指针：时间 2 * O(1) +++++ */
                // 细节问题2：目标值 为 第一个基准值
                if (mid == target) {
                    // 2、`mid == target`：返回结果
                    return nums[target];
                } else if (mid > target) {
                    // `mid > target`：目标在左分区，移动`右指针`，继续搜索左分区
                    right = mid - 1;
                } else {
                    // `mid < target`：目标在右分区，移动`左指针`，继续搜索右分区
                    left = mid + 1;
                }
            }
            // 细节问题1：只有一个元素
            return nums[left];
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            int index = left + 1;
            for (int i = index; i <= right; i++) {
                if (nums[i] <= pivot) {
                    swap(nums, i, index++);
                }
            }
            swap(nums, --index, left);
            return index;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    /**
     * 	执行耗时:18 ms,击败了43.03% 的Java用户
     * 	内存消耗:48.9 MB,击败了38.16% 的Java用户
     */
    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            /* ----- 定义了一堆数值变量：空间 O(1) ----- */
            int n = nums.length;
            int left = 0, right = n - 1, target = n - k, mid;
            /* +++++ 二分查找：时间 O(log n) +++++ */
            while (left < right) {
                // 1、利用快排的分区思想，找出 pivot 所在位置，跟 目标位置target 比较
                mid = partition(nums, left, right);
                if (mid == target) {
                    // 2、`mid == target`：返回结果
                    return nums[target];
                } else if (mid > target) {
                    // `mid > target`：目标在左分区，移动`右指针`，继续搜索左分区
                    right = mid - 1;
                } else {
                    // `mid < target`：目标在右分区，移动`左指针`，继续搜索右分区
                    left = mid + 1;
                }
            }
            return nums[left];
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            while (left < right) {
                while (left < right && pivot <= nums[right]) {
                    right--;
                }
                if (left == right) {
                    break;
                }
                nums[left++] = nums[right];
                while (left < right && nums[left] <= pivot) {
                    left++;
                }
                nums[right--] = nums[left];
            }
            nums[left] = pivot;
            return left;
        }
    }

    /**
     * 	执行耗时:33 ms,击败了25.69% 的Java用户
     * 	内存消耗:48.9 MB,击败了37.34% 的Java用户
     */
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            return quickSort(nums, 0, n - 1, n - k);
        }

        private int quickSort(int[] nums, int left, int right, int target) {
            if (left < right) {
                int mid = partition(nums, left, right);
                if (mid == target) {
                    return nums[mid];
                }
                quickSort(nums, left, mid, target);
                quickSort(nums, mid + 1, right, target);
            }
            return nums[target];
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            while (left < right) {
                while (left < right && pivot <= nums[right]) {
                    right--;
                }
                if (left == right) {
                    break;
                }
                nums[left++] = nums[right];
                while (left < right && nums[left] <= pivot) {
                    left++;
                }
                nums[right--] = nums[left];
            }
            nums[left] = pivot;
            return left;
        }
    }
}
