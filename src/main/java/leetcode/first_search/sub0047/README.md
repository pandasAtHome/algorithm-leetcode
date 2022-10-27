# 题目

- Java：[47]全排列 II
- Related Topics 数组 回溯 👍 1207 👎 0

```text
给定一个可包含重复数字的序列 nums ，
  按任意顺序 返回所有不重复的全排列。 


示例 1： 

输入：nums = [1,1,2]
输出：[[1,1,2],
      [1,2,1],
      [2,1,1]]


示例 2： 

输入：nums = [1,2,3]
输出：[[1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]]


提示： 

1 <= nums.length <= 8 
-10 <= nums[i] <= 10 
```

# 读题

- 返回一个序列中的所有不重复排序

# 法一：回溯

- 核心：深度优先搜索 + 回溯

## 思路

- 对序列进行升序排序
- 定义一个列表，记录元素是否被使用
- 定义一个栈，用于记录排序的方式
- 回溯：逐个元素入栈
  - 前后元素相同，前者未被使用：说明此方式已被记录

## 实现

### 边界问题

- 退出条件：`level == n`

### 细节问题

- 提前剪枝： `nums[i - 1] == nums[i] && !used[i - 1]`

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(log n)` + `O(n)` </br> - `O(log n)` : 排序栈空间 </br> - `O(n)` : 使用记录 & 路径
时间 | `O(n^2)` | `O(n log n)` + `O(n ^ 2)` </br> - `O(n log n)` : 排序 </br> - `O(n^2)` : 回溯

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | 只有一个元素
其次 | `O(n)` | `O(n^2)` | 有重复元素
最坏 | `O(n)` | `O(n^2)` | 没有重复元素