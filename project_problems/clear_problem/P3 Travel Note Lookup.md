# P3 Travel Note Lookup

入住酒店后，你会查看一份已经按 ID 排好序的旅行笔记目录。现在需要快速判断某篇笔记是否在目录中。

## 任务

给定按字典序升序排列的 `N` 个 `noteId`，再给定 `Q` 个查询 ID。对于每个查询：

- 若 ID 存在，输出该 ID 在目录中的 0-based 位置。
- 若 ID 不存在，输出 `NOT FOUND`。

## 输入格式

```text
N Q
noteId_1
noteId_2
...
noteId_N
queryId_1
queryId_2
...
queryId_Q
```

题目保证前 `N` 个 `noteId` 已按字典序升序排列且互不重复。

## 输出格式

每个查询输出一行：

```text
queryId index
```

若不存在：

```text
queryId NOT FOUND
```

## 示例

输入：

```text
5 4
N001
N004
N007
N010
N013
N007
N002
N013
N001
```

输出：

```text
N007 2
N002 NOT FOUND
N013 4
N001 0
```

## 复杂度建议

推荐对每个查询使用二分查找，单次查询复杂度为 `O(log N)`。压力样例会包含大量查询，线性扫描每次查询可能无法通过。
