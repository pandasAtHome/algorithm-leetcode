# 题目

- Java：[155]最小栈
- Related Topics 栈 设计 👍 1474 👎 0

```text
设计一个支持 push ，pop ，top 操作，
  并能在常数时间内检索到最小元素的栈。 
实现 MinStack 类: 
  MinStack() 初始化堆栈对象。 
  void push(int val) 将元素val推入堆栈。 
  void pop() 删除堆栈顶部的元素。 
  int top() 获取堆栈顶部的元素。 
  int getMin() 获取堆栈中的最小元素。 


示例 1: 

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.


提示： 

-2³¹ <= val <= 2³¹ - 1 
pop、top 和 getMin 操作总是在 非空栈 上调用 
push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
```

# 读题

- 设计一个最小栈，使操作时间保持在常数级

# 法一：辅助栈

- 核心：辅助栈（同步）

## 思路

- 创建一个辅助栈 `minStack`，用于记录每次 `push` 时，当前的最小值
- 每次 `pop` 时，对 `minStack` 进行同步 `pop`
- `top` 返回 `valStack.peek()`
- `getMin` 返回 `minStack.peek()`

## 实现

### 边界问题

### 细节问题

- 辅助栈 `minStack` 初始化时，需要设置一个值 `Integer.MAX_VALUE`

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(n)` | `O(n)` </br> - 同步记录当前的最小值
时间 | `O(1)` | `O(1)` </br> - 平均操作时间

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(n)` | `O(1)` |

# 法二：双重插入

- 核心：双重插入（异步）

## 思路

- `push` 时，如果存在更小值(`≤ minVal`)，先插入当前 `minVal`，再替换 `minVal` 的值
- `pop` 时，如果是当前的 `minVal`，则多执行一次 `pop`
- `top` 返回 `valStack.peek()`
- `getMin` 返回 `minVal`

## 实现

### 边界问题

### 细节问题

- 实例化时，`minVal = Integer.MAX_VALUE`

### [代码实现](Demo01.java)

### 复杂度

类型 | 复杂度 | 说明
:--- |:--- |:---
空间 | `O(L)` | `O(L)` </br> - 双重插入的次数
时间 | `O(1)` | `O(1)` </br> - 平均操作时间

### 总结

情况 | 空间复杂度 | 时间复杂度 | 说明
:--- |:--- |:--- |:---
最好 | `O(L)` | `O(1)` |
