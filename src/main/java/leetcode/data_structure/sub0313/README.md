# 题目

- Java：[313]超级丑数
- Related Topics 数组 数学 动态规划 👍 359 👎 0

```text
超级丑数 是一个正整数，
  并满足其所有质因数都出现在质数数组 primes 中。 
给你一个整数 n 和一个整数数组 primes ，
  返回第 n 个 超级丑数 。 
题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。 


示例 1： 

输入：n = 12, primes = [2,7,13,19]
输出：32 
解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，
前 12 个超级丑数序列为：
  [1,2,4,7,8,13,14,16,19,26,28,32] 。 


示例 2： 

输入：n = 1, primes = [2,3,5]
输出：1
解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。


提示： 

1 <= n <= 10⁵ 
1 <= primes.length <= 100 
2 <= primes[i] <= 1000 
题目数据 保证 primes[i] 是一个质数 
primes 中的所有值都 互不相同 ，且按 递增顺序 排列 
```

# 读题

- 找到 质因数 都在数组 primes 中的 第 n 个丑数

# 法一：优先队列

- 核心：优先队列

## 思路

- 创建一个优先队列，质数值较小的排前面
  - `格式：[质数, 质数索引, 丑数索引]`
- 把 质数数组入队
- 遍历需要找的第 n 个丑数

## 实现

### 边界问题

### 细节问题

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(n)` </br> - 记录前n个丑数
时间 | `O(n)` | `O(k)` + `O(n)` </br> - `O(k)` : 遍历质数数组 </br> - `O(n)` : 寻找第n个丑数

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | - `n = 1`
最坏 | `O(n)` | `O(n)` | - 其他