# 题目

- Java：[1]两数之和
- Related Topics 数组 哈希表 👍 16205 👎 0

```text
给定一个整数数组 nums 和一个整数目标值 target，
  请你在该数组中找出 和为目标值 target 的那 两个 整数，
  并返回它们的数组下标。 
你可以假设每种输入只会对应一个答案。
  但是，数组中同一个元素在答案里不能重复出现。 
你可以按任意顺序返回答案。 


示例 1： 

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。


示例 2： 

输入：nums = [3,2,4], target = 6
输出：[1,2]


示例 3： 

输入：nums = [3,3], target = 6
输出：[0,1]


提示： 

2 <= nums.length <= 10⁴ 
-10⁹ <= nums[i] <= 10⁹ 
-10⁹ <= target <= 10⁹ 
只会存在一个有效答案 
进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
```

# 读题

- 在一个整数数组中，存在两个数之和等于 `target`，找出这两个数在数组中的索引

# 法一：hash 表

- 核心：hash 表

## 思路

- 建立一个 `hash` 表，记录每个数字及其在数组中的索引
- 遍历每个数字，计算出与目标值之差 `diff = target - nums[i]`
- 查看差值是否在 `hash` 表中

## 实现

### 边界问题

- 只有两个数值

### 细节问题

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(n)` </br> - 记录每个数字及其索引
时间 | `O(n)` | `O(n)` </br> - 遍历所有数字

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | - 边界问题1
最坏 | `O(n)` | `O(n)` | - 其他