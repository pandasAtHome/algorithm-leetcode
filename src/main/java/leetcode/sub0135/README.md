# 题目

- Java：[135]分发糖果
- Related Topics 贪心 数组 👍 959 👎 0

```text
n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
你需要按照以下要求，给这些孩子分发糖果： 
  每个孩子至少分配到 1 个糖果。 
  相邻两个孩子评分更高的孩子会获得更多的糖果。 
请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 


示例 1： 

输入：ratings = [1,0,2]
输出：5
解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。


示例 2： 

输入：ratings = [1,2,2]
输出：4
解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
    第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 


提示： 

n == ratings.length 
1 <= n <= 2 * 10⁴ 
0 <= ratings[i] <= 2 * 10⁴ 

```

# 读题

- `n 个孩子站成一排` => `一个固定队列`
- 每个孩子至少分配到 1 个糖果

```java
/* ----- 定义一个糖果数组：空间 O(n) ----- */
int[] numOfCandy = new int[length];
/* +++++ 遍历数组：时间 O(3n) +++++ */
Arrays.fill(numOfCandy, 1);
```

- `相邻两个孩子` => `评分更高的孩子` => `获得更多的糖果`

```java
// `right分数 > left分数` => `right糖果 = left糖果 + 1`
numOfCandy[i] = numOfCandy[i - 1] + 1;
// `left分数 > right分数` => `left糖果 = max(left糖果, right糖果 + 1)`
numOfCandy[i] = Math.max(numOfCandy[i], numOfCandy[i + 1] + 1);
```

# 思路

- 从左往右遍历，找出右边较大者
  - `right分数 > left分数` => `right糖果 = left糖果 + 1`

```java
for (int i = 1; i < length; i++) {
    // right = i,  left = i - 1
    /* +++++ N次较大者判断：时间 O(n) +++++ */
    if (ratings[i] > ratings[i - 1]) {
        // `right分数 > left分数` => `right糖果 = left糖果 + 1`
        numOfCandy[i] = numOfCandy[i - 1] + 1;
    }
}
```

- 从右往左遍历，找出左边较大者
  - `left分数 > right分数` => `left糖果 = max(left糖果, right糖果 + 1)`
    - 举例：

    ```text
    每人分数如下：
    ratings = [1, 3, 4, 5, 2]

    初始化糖果数：
    numOfCandy = [1, 1, 1, 1, 1]

    从左往右遍历，结束时：
    numOfCandy = [1, 2, 3, 4, 1]

    从右往左遍历：
      令： 
        分数5 = ratings[3]
        分数2 = ratings[4]
        分数4糖果 = numOfCandy[2]
        分数5糖果 = left糖果 = numOfCandy[3]
        right糖果 = numOfCandy[4]
      因为： 分数5 > 分数2
      此时： `left糖果`(=4) > `right糖果 + 1`(= 1 + 1 = 2)
      需使： `分数4糖果`(=3) < `分数5糖果`
      所以： `分数5糖果` = `left糖果`(=4)

    ```

```java
for (int i = length - 2; i >= 0; i--) {
    // left = i,  right = i + 1
    /* +++++ N次较大者判断：时间 O(n) +++++ */
    if (ratings[i] > ratings[i + 1]) {
        // `left分数 > right分数` => `left糖果 = max(left糖果, right糖果 + 1)`
        numOfCandy[i] = Math.max(numOfCandy[i], numOfCandy[i + 1] + 1);
    }
}
```

# 实现

## 边界问题

- 只有一个孩子(1 <= n <= 2 * 10⁴)

```java
if (length < 2) {
    return length;
}
```

- 从左往右遍历
  - `[1, length)`

```java
for (int i = 1; i < length; i++) {
    ...
}
```

- 从右往左遍历
  - `[0, length - 2]`

```java
for (int i = length - 2; i >= 0; i--) {
    ...
}
```

## [代码实现](Demo01.java)

## 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `4 * O(1)` + `O(n)` </br> - `O(1)` : 4个数值变量 </br> - `O(n)` : 1个数组
时间 | `O(n)` | `4 * O(3n)` + `4 * O(n)` </br> - `O(3n)` : 4个for循环 </br> - `O(n)` : for循环里面的判断 或 赋值
