# 题目

- Java：[77]组合
- Related Topics 回溯 👍 1139 👎 0

```text
给定两个整数 n 和 k，
  返回范围 [1, n] 中所有可能的 k 个数的组合。 

你可以按 任何顺序 返回答案。 


示例 1： 

输入：n = 4, k = 2
输出：
[
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
] 


示例 2： 

输入：n = 1, k = 1
输出：[[1]] 


提示： 

1 <= n <= 20 
1 <= k <= n 
```

# 读题

- 返回 `[1, n]` 中组成的 k 个数字的排序方式
- 可以按任何顺序返回
  - 其中 `{1, 2}` 和 `{2, 1}` 为同一种排序方式，只返回其中一个

# 法一：回溯法

- 核心：回溯 + 深度优先搜索

## 思路

- 定义一个队列，用于记录当前查找的排序方式
- 定义一个计数器，用于记录当前排序方式队列的长度
- 开始寻找所有可能的排序方式
  - 排序组合达到最大数量，把排序方式加入结果集
  - 锁定状态：计数 +1
  - 数字加入队列
  - 寻找下一个数字
  - 数字出队，寻找下一种可能
  - 解锁状态：计数 -1

## 实现

### 边界问题

- 退出条件：`count == k`

### 细节问题

- 当剩下的数字不足以组成 `长度=k` 的数组时，即可结束

``` text
对于 n = 4, k = 2
当 queue[0] = 4 时，已经没有后续数字了
所以 第一位数字，只需遍历到 n = 3 即可
  成立：
    [1, x]   2 <= x <= 4
    [2, x]   3 <= x <= 4
    [3, x]   4 <= x <= 4

  不成立：
    [4, x]   5 <= x <= 4
```

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | O($C_{k}^{n}$) | O($C_{k}^{n}$) + `O(k)` + `O(1)` </br> - O($C_{k}^{n}$) : 递归栈空间 </br> - `O(k)` : 当前寻找的排序方式的队列 </br> - `O(1)` : 计数器
时间 | O($C_{k}^{n}$) | O($C_{k}^{n}$) : 递归

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(k)` | `O(1)` | 只有一个元素
其次 | `O(k)` | `O(k)` | `n = k`
最坏 | O($C_{k}^{n}$) | O($C_{k}^{n}$) | `n > k`