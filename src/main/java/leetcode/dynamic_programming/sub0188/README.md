# 题目

- Java：[188]买卖股票的最佳时机 IV
- Related Topics 数组 动态规划 👍 827 👎 0

```text
给定一个整数数组 prices ，
  它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 

设计一个算法来计算你所能获取的最大利润。
  你最多可以完成 k 笔交易。 
  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 


示例 1： 

输入：k = 2, prices = [2,4,1]
输出：2
解释：
  在第 1 天 (股票价格 = 2) 的时候买入，
    在第 2 天 (股票价格 = 4) 的时候卖出，
    这笔交易所能获得利润 = 4-2 = 2 。 


示例 2： 

输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：
  在第 2 天 (股票价格 = 2) 的时候买入，
    在第 3 天 (股票价格 = 6) 的时候卖出, 
    这笔交易所能获得利润 = 6-2 = 4 。
  随后，在第 5 天 (股票价格 = 0) 的时候买入，
    在第 6 天 (股票价格 = 3) 的时候卖出, 
    这笔交易所能获得利润 = 3-0 = 3 。 


提示： 

0 <= k <= 100 
0 <= prices.length <= 1000 
0 <= prices[i] <= 1000 
```

# 读题

- 最多可进行 k 次 买入卖出，求能获取的最大利润

# 法一：动态规划

- 核心：动态规划

## 思路

- 定义一个数组：`buy[j]` 表示 `第j次` 买入时，最大获利
  - 初始化买入时的获利为最小值
- 定义一个数组：`sell[j]` 表示 `第j次` 卖出时，最大获利
- 遍历股票的所有价格，计算利润
- 更新每次购买的利润

## 实现

### 边界问题

- 没有价格 或 不可进行买卖：`k == 0` or `prices.length == 0`

### 细节问题

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(k)` | `O(k)` </br> - 记录 每次买入卖出，当前的最大利润
时间 | `O(nk)` | `O(nk)` + `O(k)` </br> - `O(nk)` : 遍历股票价格 & 买卖次数 </br> - `O(k)` : 初始化 每次交易，买入时当前的剩余的最大利润

### 总结

- `k`：买卖次数

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | - 边界问题1
最坏 | `O(k)` | `O(nk)` | - 其他情况
