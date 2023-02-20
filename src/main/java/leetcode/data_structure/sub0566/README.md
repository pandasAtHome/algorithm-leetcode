# 题目

- Java：[566]重塑矩阵
- Related Topics 数组 矩阵 模拟 👍 374 👎 0

```text
在 MATLAB 中，
  有一个非常有用的函数 reshape ，
  它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，
  但保留其原始数据。 
给你一个由二维数组 mat 表示的 m x n 矩阵，
  以及两个正整数 r 和 c ，
  分别表示想要的重构的矩阵的行数和列数。 
重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。 
如果具有给定参数的 reshape 操作是可行且合理的，
  则输出新的重塑矩阵；
  否则，输出原始矩阵。 


示例 1： 

输入：mat = [[1,2],[3,4]], r = 1, c = 4
输出：[[1,2,3,4]]


示例 2： 

输入：mat = [[1,2],[3,4]], r = 2, c = 4
输出：[[1,2],[3,4]]


提示： 

m == mat.length 
n == mat[i].length 
1 <= m, n <= 100 
-1000 <= mat[i][j] <= 1000 
1 <= r, c <= 300 
```

# 读题

- 把一个 `m x n` 的矩阵转换为 `r x c` 矩阵

# 法一：降维转换

- 核心：降维转换（二维转一维）

## 思路

- 按 `[0, m*n]` 遍历所有元素
- 匹配新旧矩阵的元素位置
  - 新矩阵：`row = i / 新列数; col = i % 新列数`
  - 旧矩阵：`row = i / 旧列数; col = i % 旧列数`

## 实现

### 边界问题

### 细节问题

- `m * n != r * c`：直接返回

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(1)` | `O(1)` </br> -
时间 | `O(mn)` | `O(mn)` </br> - 遍历所有元素

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | - 细节问题1
最坏 | `O(1)` | `O(mn)` | - 其他