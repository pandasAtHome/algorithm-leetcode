# 题目

- Java：[307]区域和检索 - 数组可修改
- Related Topics 设计 树状数组 线段树 数组 👍 578 👎 0

```text
给你一个数组 nums ，请你完成两类查询。 
其中一类查询要求 更新 数组 nums 下标对应的值 
另一类查询要求返回数组 nums 中
  索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，
  其中 left <= right 
实现 NumArray 类： 
  NumArray(int[] nums) 
    用整数数组 nums 初始化对象 
  void update(int index, int val) 
    将 nums[index] 的值 更新 为 val 
  int sumRange(int left, int right) 
    返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 
    （即，nums[left] + nums[left + 1], ..., nums[right]） 


示例 1： 

输入：
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
输出：
[null, 9, null, 8]

解释：
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2);  返回 1 + 3 + 5 = 9
numArray.update(1, 2);    nums = [1,2,5]
numArray.sumRange(0, 2);  返回 1 + 2 + 5 = 8


提示： 

1 <= nums.length <= 3 * 10⁴ 
-100 <= nums[i] <= 100 
0 <= index < nums.length 
-100 <= val <= 100 
0 <= left <= right < nums.length 
调用 update 和 sumRange 方法次数不大于 3 * 10⁴ 
```

# 读题

# 法一：线段树

- 核心：线段树

## 思路

- 初始化时，构建一棵线段树
- 叶子结点，存储 `nums` 数组中的每个元素值
- 子节点，存储 `nums` 数组的每个区间的数值之和

## 实现

### 边界问题

### 细节问题

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(n)` </br> - `O()`
时间 | `O(n)` | `O(n)` + `O(log n)` + `O(log n)` </br> - `O(n)`: 初始化线段树 </br> - `O(log n)`: update 数值 </br> - `O(n)`: sumRange 求区间和

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
平均 | `O(n)` | `O(n)` | -
