# 题目

- Java：[693]交替位二进制数
- Related Topics 位运算 👍 222 👎 0

```text
给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：
  换句话说，就是二进制表示中相邻两位的数字永不相同。 


示例 1： 

输入：n = 5
输出：true
解释：5 的二进制表示是：101


示例 2： 

输入：n = 7
输出：false
解释：7 的二进制表示是：111. 


示例 3： 

输入：n = 11
输出：false
解释：11 的二进制表示是：1011. 


提示： 

1 <= n <= 2³¹ - 1 
```

# 读题

- 判断一个数字的二进制相邻的两位是否不相同

# 法一：位运算

- 核心：位运算

## 思路

- 假设 n 为 相邻两位不相同的数字
- `n ^ (n >> 1)` 会得到一个 `左边全是0，右边全是1` 的二进制 (`...0000 1111...`)
- `(n ^ (n >> 1)) + 1` 会得到一个 `中间只有一个1，左右两边全是0` 的二进制 (`...0001 0000...`)

## 实现

### 边界问题

### 细节问题

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(1)` | `O(1)` </br> - 存储转换结果
时间 | `O(1)` | `O(1)` </br> - 位计算

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` |
