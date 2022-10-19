# 题目

- Java：[126]单词接龙 II
- Related Topics 广度优先搜索 哈希表 字符串 回溯 👍 612 👎 0

```text
按字典 wordList 完成
  从单词 beginWord 到单词 endWord 转化，
  一个表示此过程的 转换序列 是形式上像 
    beginWord -> s1 -> s2 -> ... -> sk 
  这样的单词序列，并满足： 
    每对相邻的单词之间仅有单个字母不同。 
    转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。
      注意，beginWord 不必是字典 wordList 中的单词。 
    sk == endWord 

给你两个单词 beginWord 和 endWord ，
  以及一个字典 wordList 。
  请你找出并返回所有从 beginWord 到 endWord 的最短转换序列 ，
  如果不存在这样的转换序列，返回一个空列表。
  每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。 


示例 1： 

输入：beginWord = "hit", 
     endWord = "cog", 
     wordList = ["hot","dot","dog","lot","log","cog"]
输出：[["hit","hot","dot","dog","cog"],
      ["hit","hot","lot","log","cog"]]
解释：存在 2 种最短的转换序列：
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"


示例 2： 

输入：beginWord = "hit", 
     endWord = "cog", 
     wordList = ["hot","dot","dog","lot","log"]
输出：[]
解释：endWord "cog" 不在字典 wordList 中，
     所以不存在符合要求的转换序列。


提示： 

1 <= beginWord.length <= 5 
endWord.length == beginWord.length 
1 <= wordList.length <= 500 
wordList[i].length == beginWord.length 
beginWord、endWord 和 wordList[i] 由小写英文字母组成 
beginWord != endWord 
wordList 中的所有单词 互不相同 
```

# 读题

- 使用 `wordList` 中的单词，使得 `startWord` 变为 `endWord`
  - `startWord` 可以不在 `wordList` 中
  - `endWord` 必须在 `wordList` 中
- 找出最短的转换路径
  - 链路中的相邻单词，只有一个字母不同

# 法一：深度优先搜索

- 核心：图 + 深度优先搜索

## 思路

- 生成各个单词的匹配模式
  - `abc => [*bc, a*c, ab*]`
- 通过(匹配模式)连接点构建图
- 检测 `endWord` 是否在 `wordList` 中
- 构建路径方向，确定单词坐标点
- 判断可达性：`beginWord ?=> endWord`
- 寻找所有可达的最短路径

## 实现

### 边界问题

- `endWord` 不在 `wordList` 中即可退出

### 细节问题

- 可达性判断：`endNode.index ?== Integer.MAX_VALUE`

### [代码实现](Demo01.java)

### 复杂度

- `n = wordList.length`
- `L = wordList[i].length`
- `S = shortestPath.length`

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n * L)` | `O(n * L)` + `O(S)` </br> - `O(n * L)` : 节点遍历 </br> - `O(S)` : 最短路径
时间 | `O(n * L)` | `O(n * L)` + `O(S)` </br> - `O(n * L)` : 节点遍历 </br> - `O(S)` : 最短路径

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(n * L)` | `O(n * L)` | 边界问题1
其次 | `O(n * L)` | `O(n * L)` | 细节问题1
最差 | `O(n * L)` | `O(n * L)` | 正常情况
