# 题目

- Java：[343]整数拆分
- Related Topics 数学 动态规划 👍 969 👎 0

```text
给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），
  并使这些整数的乘积最大化。 
  返回 你可以获得的最大乘积 。 


示例 1: 

输入: n = 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。 


示例 2: 

输入: n = 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 


提示: 

2 <= n <= 58 
```

# 读题

- 求 `正整数 n` 拆分为 `k` 个 正整数的最大乘积

# 法一：动态规划

- 核心：动态规划

## 思路

- 定义一个数组：记录 `[2, n]` 拆分为整数后的最大乘积
- 计算每个数字的最大乘积

数字 | 公式
--- |---
`[1, 2]` | `i - 1`
`[3, 4]` | `2 * (i - 2)`
`[5, 6]` | `3 * (i - 3)`
`[7, n]` | `3 * dp[i - 3]`

## 实现

### 边界问题

- 1~2 返回 `n - 1`

### 细节问题

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(n)` </br> - 记录 每个数字的最大乘积
时间 | `O(n)` | `O(n)` </br> - 遍历所有正整数

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | - 边界问题1
最坏 | `O(n)` | `O(n)` | - 其他