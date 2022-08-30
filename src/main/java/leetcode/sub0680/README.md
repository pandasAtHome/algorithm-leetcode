# 题目

- Java：[680]验证回文串 II
- Related Topics 贪心 双指针 字符串 👍 528 👎 0

```text
给你一个字符串 s，最多 可以从中删除一个字符。 

请你判断 s 是否能成为回文字符串：
  如果能，返回 true ；
  否则，返回 false 。 


示例 1： 

输入：s = "aba"
输出：true


示例 2： 

输入：s = "abca"
输出：true
解释：你可以删除字符 'c' 。


示例 3： 

输入：s = "abc"
输出：false 


提示： 

1 <= s.length <= 10⁵ 
s 由小写英文字母组成 
```

# 读题

- 最多删除字符串中一个字符，使其变成回文字符串

# 法一：双指针 + 贪心算法

- 核心：首尾指针

## 思路

- 定义一对首尾指针，夹逼搜索
- 相等，首尾指针向中间移动
- 不等
  - 假设左边删除一个元素，是为回文，返回true，否则：
  - 假设右边删除一个元素，判断是否为回文，返回结果

## 实现

### 边界问题

- 退出条件：`left > right`

### 细节问题

- `1 <= s.length() <= 2`，是回文
- 可能需要多次获取字符串中某个位置的字符，所以转换为字符数组
- 字符串全是小写，无需做大小写转换

### [代码实现](/src/main/java/leetcode/sub0680/Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `3 * O(1)` + `O(n)` </br> - `O(1)` : 数值变量 </br> - `O(n)` : 字符数组
时间 | `O(n)` | `O(n)` + `O(3n)` + `O(2n)` </br> - `O(n)` : 遍历字符数组 </br> - `O(3n)` : 回文判断 & 获取字符 </br> - `O(2n)` : 挪动指针

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | 无 | `O(1)` | 细节问题1
其次 | `O(n)` | `O(n)` | `回文字符串`(无需删除字符)
最差 | `O(n)` | `O(n)` | `不是回文字符串` or `回文字符串`(需删除字符)