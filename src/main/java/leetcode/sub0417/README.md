# 题目

- Java：[417]太平洋大西洋水流问题
- Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 528 👎 0

```text
有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 
  “太平洋” 处于大陆的左边界和上边界，
  而 “大西洋” 处于大陆的右边界和下边界。 

这个岛被分割成一个由若干方形单元格组成的网格。
  给定一个 m x n 的整数矩阵 heights ， 
  heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。 

岛上雨水较多，
  如果相邻单元格的高度 小于或等于 当前单元格的高度，
  雨水可以直接向北、南、东、西流向相邻单元格。
  水可以从海洋附近的任何单元格流入海洋。 

返回网格坐标 result 的 2D 列表 ，
  其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 
  既可流向太平洋也可流向大西洋 。 


示例 1： 

输入: heights = [[1,2,2,3,5],
                [3,2,3,4,4],
                [2,4,5,3,1],
                [6,7,1,4,5],
                [5,1,1,2,4]]
输出: [[0,4],
      [1,3],
      [1,4],
      [2,2],
      [3,0],
      [3,1],
      [4,0]]


示例 2： 

输入: heights = [[2,1],
                [1,2]]
输出: [[0,0],
      [0,1],
      [1,0],
      [1,1]]


提示： 

m == heights.length 
n == heights[r].length 
1 <= m, n <= 200 
0 <= heights[r][c] <= 10⁵ 
```

# 读题

- `heights[r][c]` 表示海拔高度
- 太平洋位于大陆左上方，大西洋位于大陆右下方
- 水只能从高往低处流动，求能同时流向太平洋和大西洋的陆地节点

# 法一：深度优先搜索

- 核心：深度优先搜索 + 逆向思维（水往高处走）

## 思路

- 定义一个坐标盘，记录下所有能流向 `太平洋` 的节点
- 定义一个坐标盘，记录下所有能流向 `大西洋` 的节点
- 找出同时能流向 `太平洋` 和 `大西洋` 的节点

## 实现

### 边界问题

- 只搜索大陆上的节点：
  - `0 <= x < xMax`
  - `0 <= y < yMax`
- 只寻找海拔持平 或 更高的节点

### 细节问题

- 用一个 一维数组 存放当前节点的 偏移量

### [代码实现](/src/main/java/leetcode/sub0417/Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(mn)` | `O(mn)` + `O(m)` + `O(n)` + `O(1)` </br> - `O(mn)` : 分别流向`太平洋`或`大西洋`的水流路径 </br> - `O(m)` : 遍历左右边界 </br> - `O(n)` : 遍历上下边界 </br> - `O(1)` : 数值变量
时间 | `O(mn)` | `O(mn)` + `O(m)` + `O(n)` </br> - `O(mn)` : 寻找能流向`太平洋`和`大西洋`的节点 </br> - `O(m)` : 遍历左右边界 </br> - `O(n)` : 遍历上下边界

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | 只有一个节点
最坏 | `O(mn)` | `O(mn)` | 多个节点