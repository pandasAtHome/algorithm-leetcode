# 题目

- Java：[75]颜色分类
- Related Topics 数组 双指针 排序 👍 1392 👎 0

```text
给定一个包含红色、白色和蓝色、共 n 个元素的数组
nums ，
  原地对它们进行排序，
  使得相同颜色的元素相邻，
  并按照红色、白色、蓝色顺序排列。 

我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 

必须在不使用库的sort函数的情况下解决这个问题。 


示例 1： 

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]


示例 2： 

输入：nums = [2,0,1]
输出：[0,1,2]


提示： 

n == nums.length 
1 <= n <= 300 
nums[i] 为 0、1 或 2 


进阶： 

你可以不使用代码库中的排序函数来解决这道题吗？ 
你能想出一个仅使用常数空间的一趟扫描算法吗？ 
```

# 读题

- 对一个数组进行 `in-place` 升序排序

# 法一：双指针 + 快速排序

- 核心：双指针 + 快排的分区思想

## 思路

- 由于只有3种数字，选取中间的数字为基准值`(pivot = 1)`
- 假设 `基准值` 在数组中第一次出现的位置为 `oneIndex = 0`
- 分区：
  - `curVal < pivot`: 交换 `start` 和 `oneIndex`，并移动 `start` 和 `oneIndex` 指针
  - `curVal == pivot`: 移动 `start` 指针
  - `curVal > pivot`: 交换 `end` 和 `oneIndex`，并移动 `end` 指针

## 实现

### 边界问题

- 退出条件：`start > end`

### 细节问题

- 由于只有3个数，
  - 选取 `pivot = 1` 作为基准值，
  - 假设其在数组中第一次出现的位置为 `oneIndex = 0`
  - 每当有 `< pivot` 的值，与 `oneIndex` 交换位置，并移动 `oneIndex`

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(1)` | `O(1)` </br> - `O(1)` : 数值变量
时间 | `O(n)` | `O(n)` </br> - `O(n)` : 遍历数组 & 条件判断 & 移动指针

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | 只有一个元素
最坏 | `O(1)` | `O(n)` | 其他情况
