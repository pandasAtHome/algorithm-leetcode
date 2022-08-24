# 题目

- Java：[763]划分字母区间
- Related Topics 贪心 哈希表 双指针 字符串 👍 800 👎 0

```text
字符串 S 由小写字母组成。
我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
返回一个表示每个字符串片段的长度的列表。 


示例： 

输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。


提示： 

S的长度在[1, 500]之间。 
S只包含小写字母 'a' 到 'z' 。 
```

# 读题

- 字符串 S 由小写字母组成。
  - 意思：只有26种字符
- 划分为尽可能多的片段
- 同一字母最多出现在一个片段中
- 返回一个片段的长度的列表。

# 法一：贪心算法 + 双指针

## 思路

- 记录每个字符最后一次出现的位置
- 寻找每个片段的最后一个字符，截取片段

## 实现

### 边界问题

- 字符串只包含一个字符

```java
if (length == 1) {
    result.add(1);
    return result;
}
```

- 截取条件：`当前字符位置` == `当前片段中位置最后的一个字符的位置`

```java
end = Math.max(locations[chars[i] - 'a'], end);
// 截取条件：`当前字符位置` == `当前片段中位置最后的一个字符的位置`
if (i == end) {
    result.add(i - prevStart);
    prevStart = i;
}
```

### 细节问题

- 转为字符数组处理([详情>>>](/java-knowledge/string/toCharArray_vs_charAt.md))

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `4 * O(1)` + `O(n)` + `O(∣Σ∣)` </br> -`O(1)` : 4个数值变量 </br> -`O(n)` : 字符串转字符数组 </br> -`O(∣Σ∣)` : 长度位26的int数组
时间 | `O(n)` | `2 * O(3n)` + `O(2n)` + `3 * O(n)` </br> - `O(3n)` : 数组遍历 </br> - `O(2n)` : 字符串转字符数组 </br> - `O(n)` : 条件判断、赋值