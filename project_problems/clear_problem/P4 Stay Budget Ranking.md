# P4 Stay Budget Ranking

确定旅行线索后，你需要在酒店附近筛选住宿、餐厅或休息点。每个地点有价格、评分和距离，你需要按预算与距离限制输出推荐列表。

## 任务

给定 `N` 个地点和 `Q` 个查询。每个地点包含：

- `id`
- `price`
- `rating`
- `distance`

每个查询给出 `minPrice maxPrice maxDistance K`。候选地点必须满足：

- `minPrice <= price <= maxPrice`
- `distance <= maxDistance`

候选地点排序规则：

1. `rating` 降序。
2. `price` 升序。
3. `distance` 升序。
4. `id` 字典序升序。

## 输入格式

```text
N Q
id price rating distance
...
minPrice maxPrice maxDistance K
...
```

## 输出格式

每个查询输出一行，包含最多 `K` 个地点 ID。若没有候选地点，输出：

```text
NONE
```

## 示例

输入：

```text
6 3
H1 120 88 800
H2 90 80 300
H3 160 92 1200
R1 60 86 200
R2 70 91 900
H4 110 89 400
50 130 1000 3
100 170 1500 4
10 50 2000 2
```

输出：

```text
R2 H4 H1
H3 H4 H1
NONE
```

## 复杂度建议

可以对每个查询筛选候选地点后排序。请使用标准库排序和清晰的比较器，避免手写低效排序。
