说明：此练习是基于《LeetCode 101: A LeetCode Grinding Guide (C++ Version)》的

# 贪心算法

- 定义：保证每次操作**局部最优**，从而使得**结果最优**
- 核心：局部最优 =》 全局最优
- [题目](algorithm-training/1.greedy.md)

# 双指针

- 定义：遍历数组时，使用两个指针指向不同的元素，从而协同完成任务
- 延伸：
  - 多个数组，多个指针
  - 同一数组
    - 遍历**方向相同**，指针不相交
      - 简称：<b style="color: red">滑动窗口</b>
      - 作用：**区间搜索**
    - 遍历**方向相反**
      - 作用：**搜索**
      - 场景：有序数组
- [题目](algorithm-training/2.double_pointer.md)
