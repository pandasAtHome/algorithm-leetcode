# 题目

- Java：[72]编辑距离
- Related Topics 字符串 动态规划 👍 2661 👎 0

```text
给你两个单词 word1 和 word2， 
  请返回将 word1 转换成 word2 所使用的最少操作数 。 

你可以对一个单词进行如下三种操作： 
  插入一个字符 
  删除一个字符 
  替换一个字符 


示例 1： 

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')


示例 2： 

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')


提示： 

0 <= word1.length, word2.length <= 500 
word1 和 word2 由小写英文字母组成 
```

# 读题

- 通过 修改/插入/删除 等操作，计算 从 `word1` 变为 `word2` 所需要的最少步数

# 法一：动态规划

- 核心：动态规划

## 思路

- 定义一个数组，记录：`word1[0:i]` 变为 `word2[0:j]` 所需要的最少步数
- 初始化：假设 `word2` 为空字符串
- 初始化 假设 `word1` 为空字符串
- 遍历字符，计算 从 `word1[0:i]` 转为 `word2[0:j]` 所需步数
  - `修改` 操作：字符不同 `步数 +1`
  - `插入/删除` 操作：`步数 +1`

## 实现

### 边界问题

- `word1` 或 `word2` 为空字符串

### 细节问题

- 把 `word2` 转为 char 数组，加快字符查询

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(mn)` | `O(mn)` + `O(n)` </br> - `O(mn)` : 记录：`word1[0:i]` 变为 `word2[0:j]` 所需要的最少步数 </br> - `O(n)` : `word2` 转为 `字符数组`
时间 | `O(mn)` | `O(mn)` + `O(m)` + `O(n)` </br> - `O(mn)` : 遍历 `word1` 和 `word2` 字符 </br> - `O(m)` : 初始化：假设 `word2` 为空字符串 </br> - `O(m)` : 初始化：假设 `word1` 为空字符串

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | - 边界问题1
最坏 | `O(mn)` | `O(mn)` | - 其他
