# 题目

- Java：[695]岛屿的最大面积
- Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 847 👎 0

```text
给你一个大小为 m x n 的二进制矩阵 grid 。 

岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
  这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
  你可以假设 grid 的四个边缘都被 0（代表水）包围着。 

岛屿的面积是岛上值为 1 的单元格的数目。 

计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 


示例 1： 

输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
             [0,0,0,0,0,0,0,1,1,1,0,0,0],
             [0,1,1,0,1,0,0,0,0,0,0,0,0],
             [0,1,0,0,1,1,0,0,1,0,1,0,0],
             [0,1,0,0,1,1,0,0,1,1,1,0,0],
             [0,0,0,0,0,0,0,0,0,0,1,0,0],
             [0,0,0,0,0,0,0,1,1,1,0,0,0],
             [0,0,0,0,0,0,0,1,1,0,0,0,0]]
输出：6
解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。


示例 2： 

输入：grid = [[0,0,0,0,0,0,0,0]]
输出：0


提示： 

m == grid.length 
n == grid[i].length 
1 <= m, n <= 50 
grid[i][j] 为 0 或 1 
```

# 读题

- 计算岛屿的总面积，即计算两两相邻为1的数量

# 法一：深度优先搜索

- 核心：深度优先搜索 + 标记

## 思路

- 检索陆地
- 统计岛屿的面积（所有连在一块的陆地）
- 排除 `矩阵外的节点` 和 `海洋节点 or 已统计的陆地节点`
- 去除已统计的陆地（标记为 0）
- 统计当前陆地及其四周陆地的总面积

## 实现

### 边界问题

- 矩阵边界：
  - `0 < x < n`
  - `0 < y < m`

### 细节问题

- [上下左右](/src/main/java/leetcode/sub0695/Demo02.java)四个坐标可以使用一个 `长度=5` 的一维数组存储（两两组成一对坐标）

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(m * n)` | `O(m * n)` </br> - 递归栈空间消耗
时间 | `O(m * n)` | `O(m * n)` </br> - 矩阵遍历

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | 只有 1 个陆地节点
其次 | `O(m * n)` | `O(m * n)` | 全部都是海洋节点
最差 | `O(m * n)` | `O(m * n)` | 部分是陆地节点
