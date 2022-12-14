# 题目

- Java：[451]根据字符出现频率排序
- Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 👍 429 👎 0

```text
给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。
  一个字符出现的 频率 是它出现在字符串中的次数。 

返回 已排序的字符串 。如果有多个答案，返回其中任何一个。 


示例 1: 

输入: s = "tree"
输出: "eert"
解释: 'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。


示例 2: 

输入: s = "cccaaa"
输出: "cccaaa"
解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。


示例 3: 

输入: s = "Aabb"
输出: "bbAa"
解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。


提示: 

1 <= s.length <= 5 * 10⁵ 
s 由大小写英文字母和数字组成 
```

# 读题

- 对一个字符串按照字符出现频率倒序排列

# 法一：hash表 + 快排

- 核心：Hash表统计词频，快排倒序

## 思路

- 统计词频
- 按频率倒序
- 返回结果

## 实现

### 边界问题

- 排序退出条件：`left >= right`

### 细节问题

- 没有重复字符
- 转换为数组，方便排序时，交换位置

### [代码实现](Demo01.java)

### 复杂度

- `n`：字符串长度
- `m`：字符串中，不相同的字符的数量

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(1)` + `O(n)` + `O(log m)` + `O(m)` </br> - `O(1)` : 数值变量 </br> - `O(n)` : 词频统计 </br> - `O(log m)` : 快排栈空间消耗 </br> - `O(m)` : map转数组
时间 | `O(m log m)` | `O(n)` + `O(m)` + `O(m log m)` </br> - `O(n)` : 词频统计 </br> - `O(m)` : map转数组 </br> - `O(m log m)` : 快排

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(n)` | `O(n)` | 细节问题1
其次 | `O(m)` | `O(m)` | 重复字符数量 = 不重复字符数量
最差 | `O(m)` | `O(m log m)` | 都是重复字符
