# 题目

- Java：[697]数组的度
- Related Topics 数组 哈希表 👍 458 👎 0

```text
给定一个非空且只包含非负数的整数数组 nums，
  数组的 度 的定义是指数组里任一元素出现频数的最大值。 
你的任务是在 nums 中找到
  与 nums 拥有相同大小的度的最短连续子数组，
  返回其长度。 


示例 1： 

输入：nums = [1,2,2,3,1]
输出：2
解释：
输入数组的度是 2 ，
  因为元素 1 和 2 的出现频数最大，
  均为 2 。
连续子数组里面拥有相同度的有如下所示：
  [1, 2, 2, 3, 1], 
  [1, 2, 2, 3], 
  [2, 2, 3, 1], 
  [1, 2, 2], 
  [2, 2, 3], 
  [2, 2]
最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。


示例 2： 

输入：nums = [1,2,2,3,1,4,2]
输出：6
解释：
数组的度是 3 ，因为元素 2 重复出现 3 次。
所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。


提示： 

nums.length 在 1 到 50,000 范围内。 
nums[i] 是一个在 0 到 49,999 范围内的整数。 
```

# 读题

- 找出数组中，出现次数最多的数字的最短子数组

# 法一：hash 表

- 核心：hash 表

## 思路

- 定义一个 hash 表，记录每个数字的：
  - `[第一次出现位置, 最后一次出现位置, 出现次数]`
- 遍历 hash 表，找出出现次数最多的最多子数组

## 实现

### 边界问题

### 细节问题

- 出现次数相同时，获取链路最短的数组

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(n)` </br> - 记录每个数字的情况
时间 | `O(n)` | `O(n)` </br> - 遍历所有数字

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
平均 | `O(n)` | `O(n)` |