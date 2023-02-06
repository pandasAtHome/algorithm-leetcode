# 题目

- Java：[303]区域和检索 - 数组不可变
- Related Topics 设计 数组 前缀和 👍 529 👎 0

```text
给定一个整数数组 nums，处理以下类型的多个查询: 
  计算索引 left 和 right 
    （包含 left 和 right）之间的 nums 元素的 和，
  其中 left <= right 
实现 NumArray 类： 
  NumArray(int[] nums) 使用数组 nums 初始化对象 
  int sumRange(int i, int j) 返回数组 nums 中
    索引 left 和 right 之间的元素的 总和 ，
    包含 left 和 right 两点
    （也就是 nums[left] + nums[left + 1] + ... + nums[right] ) 


示例 1： 

输入：
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
输出：
[null, 1, -1, -3]

解释：
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2);  return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5);  return -1 (3 + (-5) + 2 + (-1)) 
numArray.sumRange(0, 5);  return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))


提示： 

1 <= nums.length <= 10⁴ 
-10⁵ <= nums[i] <= 10⁵ 
0 <= i <= j < nums.length 
最多调用 10⁴ 次 sumRange 方法 
```

# 读题

- 给出一个整数数组，计算任意范围区间内的数值之和

# 法一：hash 表

- 核心：hash 表

## 思路

- 定义一个 `hash` 表，记录 `[0, i]` 的数值累积之和
- `指定范围之和 = sums[j] - sums[i]`

## 实现

### 边界问题

### 细节问题

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(n)` </br> - 记录 `[0, i]` 的累积和
时间 | `O(n)` | `O(n)` </br> - 遍历所有数值

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
平均 | `O(n)` | `O(n)` |
