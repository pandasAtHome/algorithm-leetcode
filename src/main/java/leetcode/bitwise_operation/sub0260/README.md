# 题目

- Java：[260]只出现一次的数字 III
- Related Topics 位运算 数组 👍 684 👎 0

```text
给你一个整数数组 nums，
  其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 

你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。 


示例 1： 

输入：nums = [1,2,1,3,2,5]
输出：[3,5]
解释：[5, 3] 也是有效的答案。


示例 2： 

输入：nums = [-1,0]
输出：[-1,0]


示例 3： 

输入：nums = [0,1]
输出：[1,0]


提示： 

2 <= nums.length <= 3 * 10⁴ 
-2³¹ <= nums[i] <= 2³¹ - 1 
除两个只出现一次的整数外，nums 中的其他数字都出现两次 
```

# 读题

- 在数组 `nums` 中，找出两个只出现一次的整数

# 法一：位运算

- 核心：位运算（按位异或 / 按位与）

## 思路

- 按位异或，去除所有出现过两次的数字
  - 仅留下两个不相同的数字 `x1`, `x2` ：`xorSum = x1 ^ x2`
- 由于 `x1 != x2`，所以 `xorSum` 的二进制中，一定存在 `为1的位`
  - 求出最右边为1的位：`rightOne = xorSum & (-xorSum)`
- 分流
  - `(num & rightOne) == 0` 为 `num1`
  - `(num & rightOne) == 1` 为 `num2`

## 实现

### 边界问题

- 只有2个元素：直接返回
- 只有3个元素：返回空

### 细节问题

- `(-2)^31 <= nums[i] <= 2^31`，存在溢出风险

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(1)` | `O(1)` </br> - 存储 异或结果
时间 | `O(n)` | `O(n)` </br> - 遍历所有数字

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | - 边界问题 1/2
最坏 | `O(1)` | `O(n)` | - 其他