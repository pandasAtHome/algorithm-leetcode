# 题目

- Java：[257]二叉树的所有路径
- Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 823 👎 0

```text
给你一个二叉树的根节点 root ，
  按 任意顺序 ，
  返回所有从根节点到叶子节点的路径。 

叶子节点 是指没有子节点的节点。 


示例 1： 

输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]


示例 2： 

输入：root = [1]
输出：["1"]


提示： 

树中节点的数目在范围 [1, 100] 内 
-100 <= Node.val <= 100 
```

# 读题

- 穷举所有 `从根节点到叶子节点` 的路径

# 法一：深度优先搜索

- 核心：深度优先搜索 + 回溯

## 思路

- 定义一个列表，记录路径（`根节点 -> 叶子节点`）
- 深度搜索每个子节点，直到找到叶子节点，记录路径
  - 叶子节点：`root.left == null && root.right == null`

## 实现

### 边界问题

- 路径记录：`root.left == null && root.right == null`

### 细节问题

- `List -> Str[]` 操作，可先记录 `->`，最后删除头两个字符

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(n)` + `O(L)` </br> - `O(n)` : 遍历树节点 </br> - `O(L)` : 路径长度
时间 | `O(n)` | `O(n)` </br> - 遍历树节点

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(1)` | `O(1)` | 只有一个节点
最坏 | `O(n)` | `O(n)` | 其他情况