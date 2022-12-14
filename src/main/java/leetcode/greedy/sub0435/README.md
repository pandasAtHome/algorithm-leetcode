# 题目

- Java：[435]无重叠区间
- Related Topics 贪心 数组 动态规划 排序 👍 765 👎 0

```text
给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi]。
返回需要移除区间的最小数量，使剩余区间互不重叠 。 


示例 1: 

输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。


示例 2: 

输入: intervals = [ [1,2], [1,2], [1,2] ]
输出: 2
解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。


示例 3: 

输入: intervals = [ [1,2], [2,3] ]
输出: 0
解释: 你不需要移除任何区间，因为它们已经是无重叠的了。


提示: 

1 <= intervals.length <= 10⁵ 
intervals[i].length == 2 
-5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
```

# 读题

- 需要移除区间的最小数量
- 剩余区间互不重叠

# 法一：贪心算法

## 思路

- 按 end 值，排列区间顺序

```java
Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
```

- 记录上一区间的结束值

```java
int prevEnd = intervals[0][1];
```

- 排除不符合的区间
  - 不合规 => 移除
  - 合规 => 使用

```java
if (intervals[i][0] < prevEnd) {
    // /4.1、不合规 => 移除
    result++;
} else {
    // /4.2、合规 => 使用
    prevEnd = intervals[i][1];
}
```

- 返回移除的区间数量

## 实现

### 边界问题

- 只有一个区间，无需移除

```java
if (length < 2) {
    return 0;
}
```

- 从第二个区间开始匹配

```java
for (int i = 1; i < length; i++) {
    ...
}
```

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(log n)` | `3 * O(1)` + `O(log n)` </br> -`O(1)` : 3个数值变量 </br> -`O(log n)` : 数组排序所使用的的空间
时间 | `O(n log n)` | `O(n log n)` + `O(3n)` + `2 * O(n)` </br> - `O(n log n)` : 数组排序 </br> - `O(3n)` : for循环 </br> - `O(n)` : for循环里面的判断 或 赋值
