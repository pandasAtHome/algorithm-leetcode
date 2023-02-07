# 题目

- Java：[304]二维区域和检索 - 矩阵不可变
- Related Topics 设计 数组 矩阵 前缀和 👍 464 👎 0

```text
给定一个二维矩阵 matrix，以下类型的多个请求： 
  计算其子矩形范围内元素的总和，
  该子矩阵的 左上角 为 (row1, col1) ，
  右下角 为 (row2, col2) 。 
实现 NumMatrix 类： 
  NumMatrix(int[][] matrix) 
    给定整数矩阵 matrix 进行初始化 
  int sumRegion(int row1, int col1, int row2, int col2) 
    返回 左上角 (row1, col1) 、右下角 (row2, col2) 
    所描述的子矩阵的元素 总和 。 


示例 1： 

输入: 
["NumMatrix","sumRegion","sumRegion","sumRegion"]
[
  [
    [[3,0,1,4,2],
     [5,6,3,2,1],
     [1,2,0,1,5],
     [4,1,0,1,7],
     [1,0,3,0,5]]
  ],
  [2,1,4,3],
  [1,1,2,2],
  [1,2,2,4]
]
输出: 
[null, 8, 11, 12]

解释:
NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
0,1,7],[1,0,3,0,5]]);
numMatrix.sumRegion(2, 1, 4, 3);  return 8 (红色矩形框的元素总和)
numMatrix.sumRegion(1, 1, 2, 2);  return 11 (绿色矩形框的元素总和)
numMatrix.sumRegion(1, 2, 2, 4);  return 12 (蓝色矩形框的元素总和)


提示： 

m == matrix.length 
n == matrix[i].length 
1 <= m, n <= 200

-10⁵ <= matrix[i][j] <= 10⁵ 
0 <= row1 <= row2 < m 
0 <= col1 <= col2 < n 

最多调用 10⁴ 次 sumRegion 方法 
```

# 读题

- 在一个矩阵中，统计指定范围内的矩阵中的元素之和

# 法一：积分图

- 核心：积分图

## 思路

- 初始化：遍历矩阵中的所有元素，统计左上角矩阵的元素之和，存在当前位置中
  - 累积和 = 上 + 左 - 左上 + 当前值
- 计算指定范围内的矩阵中的元素之和
  - 矩阵和 = 右下 - 上 - 左 + 左上

## 实现

### 边界问题

### 细节问题

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(mn)` | `O(mn)` </br> - 记录每个元素所在的左上角矩阵的元素之和
时间 | `O(mn)` | `O(mn)` </br> - 遍历所有元素

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
平均 | `O(mn)` | `O(mn)` |
