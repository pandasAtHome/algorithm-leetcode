# 题目

- Java：[76]最小覆盖子串
- Related Topics 哈希表 字符串 滑动窗口 👍 2089 👎 0

```text
给你一个字符串 s 、一个字符串 t 。
返回 s 中涵盖 t 所有字符的最小子串。
如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 

注意： 
  对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
  如果 s 中存在这样的子串，我们保证它是唯一的答案。 


示例 1： 

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"


示例 2： 

输入：s = "a", t = "a"
输出："a"


示例 3: 

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。 


提示： 

1 <= s.length, t.length <= 10⁵ 
s 和 t 由英文字母组成 


进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
```

# 读题

- 在一个 `字符串s` 中找出包含另一个 `字符串t` 所有字符的最小子串
- 对于 `字符串t` 中重复的字符，每个字符都算1个单位

# 法一：双指针 + Hash 表

- 核心：使用滑动窗口，获取子串

## 思路

- 使用 Hash 表，记录 `字符串t` 中，各字符的 `出现次数` 以及 `出现过的字符`
- 从左到右滑动窗口，找出所有符合条件的子串，筛选出最小子串
- 找出符合条件的子串
  - 找到目标字符 => 字符计数 -1
  - 是需要寻找的字符(字符串t中，未在当前窗口中出现的字符) => 找到字符数 +1
- 尝试缩小窗口，找出符合条件的最小子串
  - 找到长度更小的新窗口 => 更新最小窗口信息
  - 找到目标字符 => 目标字符计数 +1
  - 是需要寻找的字符(字符串t中，未在当前窗口中出现的字符) => 找到字符数 -1
  - 缩小新窗口长度

## 实现

### 边界问题

- 从左到右遍历 `字符串S`

### 细节问题

- `s的长度` < `t的长度`
- `s的长度 == 1` && `t的长度 == 1` && `s != t`

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(1)` | `9 * O(1)` + `2 * O(C)` </br> - `O(1)` : 数值变量 </br> - `O(C)` : 2个 固定长度的数组
时间 | `O(n)` | `3 * O(2n)` + `3 * O(3n)` + `3 * O(n)` </br> - `O(2n)` : 遍历字符串 & (目标字符 获取 & 判断) </br> - `O(3n)` : `charAt`字符查询 & (目标字符 获取 & 自增 & 条件判断) </br> - `O(n)` : 计数 & 赋值 & 窗口长度判断

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | 细节问题1 & 细节问题2
第二 | `O(1)` | `O(n)` | 字符串s中 不包含 字符串t的任一字符
第三 | `O(1)` | `O(n)` | 字符串s中 包含 字符串t的部分字符
第四 | `O(1)` | `O(n)` | `sLen == tLen` && `字符串s中 包含 字符串t的全部字符`
最差 | `O(1)` | `O(n)` | `字符串s中 包含 字符串t的全部字符` && `字符串s中 存在多个子串`

### 过程示例

```text
r = 0, s[r] = A, cnt = 1, l = 0, min_l = 0, min_size = 14, chars = {A:0,B:1,C:1}
r = 1, s[r] = D, cnt = 1, l = 0, min_l = 0, min_size = 14, chars = {A:0,B:1,C:1}
r = 2, s[r] = O, cnt = 1, l = 0, min_l = 0, min_size = 14, chars = {A:0,B:1,C:1}
r = 3, s[r] = B, cnt = 2, l = 0, min_l = 0, min_size = 14, chars = {A:0,B:0,C:1}
r = 4, s[r] = E, cnt = 2, l = 0, min_l = 0, min_size = 14, chars = {A:0,B:0,C:1}
r = 5, s[r] = C, cnt = 3, l = 0, min_l = 0, min_size = 14, chars = {A:0,B:0,C:0}
 min_l = 0, min_size = 6, s[l] = A, chars = {A:1,B:0,C:0}, cnt = 2, l = 1
r = 6, s[r] = O, cnt = 2, l = 1, min_l = 0, min_size = 6, chars = {A:1,B:0,C:0}
r = 7, s[r] = D, cnt = 2, l = 1, min_l = 0, min_size = 6, chars = {A:1,B:0,C:0}
r = 8, s[r] = E, cnt = 2, l = 1, min_l = 0, min_size = 6, chars = {A:1,B:0,C:0}
r = 9, s[r] = B, cnt = 2, l = 1, min_l = 0, min_size = 6, chars = {A:1,B:-1,C:0}
r = 10, s[r] = A, cnt = 3, l = 1, min_l = 0, min_size = 6, chars = {A:0,B:-1,C:0}
 min_l = 0, min_size = 6, s[l] = D, chars = {A:0,B:-1,C:0}, cnt = 3, l = 2
 min_l = 0, min_size = 6, s[l] = O, chars = {A:0,B:-1,C:0}, cnt = 3, l = 3
 min_l = 0, min_size = 6, s[l] = B, chars = {A:0,B:0,C:0}, cnt = 3, l = 4
 min_l = 0, min_size = 6, s[l] = E, chars = {A:0,B:0,C:0}, cnt = 3, l = 5
 min_l = 0, min_size = 6, s[l] = C, chars = {A:0,B:0,C:1}, cnt = 2, l = 6
r = 11, s[r] = N, cnt = 2, l = 6, min_l = 0, min_size = 6, chars = {A:0,B:0,C:1}
r = 12, s[r] = C, cnt = 3, l = 6, min_l = 0, min_size = 6, chars = {A:0,B:0,C:0}
 min_l = 0, min_size = 6, s[l] = O, chars = {A:0,B:0,C:0}, cnt = 3, l = 7
 min_l = 0, min_size = 6, s[l] = D, chars = {A:0,B:0,C:0}, cnt = 3, l = 8
 min_l = 8, min_size = 5, s[l] = E, chars = {A:0,B:0,C:0}, cnt = 3, l = 9
 min_l = 9, min_size = 4, s[l] = B, chars = {A:0,B:1,C:0}, cnt = 2, l = 10
 ```
