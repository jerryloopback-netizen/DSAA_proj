# P1 Scenic Spot Sorting

出发前，你需要根据时间预算和金钱预算筛选候选景点，并按推荐优先级输出前若干个景点。

## 任务

给定 `N` 个景点和 `Q` 个查询。每个查询给出最多输出数量 `K`、最大花费 `maxCost` 和最大游览时间 `maxDuration`。只保留满足：

- `cost <= maxCost`
- `duration <= maxDuration`

的景点，并按以下规则排序：

1. `rating` 降序。
2. `distance` 升序。
3. `cost` 升序。
4. `id` 字典序升序。

## 输入格式

```text
N Q
id rating distance cost duration
...
K maxCost maxDuration
...
```

## 输出格式

每个查询输出一行，包含最多 `K` 个景点 ID，用空格分隔。若没有景点满足条件，输出：

```text
NONE
```

## 示例

输入：

```text
6 2
A01 95 2 120 90
A02 95 1 180 120
A03 88 3 60 45
A04 95 1 150 60
A05 70 8 40 30
A06 88 2 80 75
3 160 100
4 200 200
```

输出：

```text
A04 A01 A06
A04 A02 A01 A06
```

解释：第一个查询中 `A02` 的花费超过 `160`，被过滤；剩余景点按评分、距离、花费和 ID 排序后取前三个。

## 复杂度建议

可以对每个查询收集候选景点并使用 `Collections.sort` 或 `Arrays.sort`。压力样例会包含较多景点，请避免 `O(N^2)` 手写排序。
