# P5 Transit Network Connector

你已经确定了一组想去的景点。不同景点之间有候选接驳线路，每条线路有成本。你需要选择一组成本最低的线路，让所有景点连成一个可达网络。

## 任务

给定 `N` 个点和 `M` 条候选线路。点编号为 `0..N-1`。每条线路包含：

- `routeId`
- `u`
- `v`
- `cost`

请选择若干线路使所有点连通，并使总成本最小。若无法连通，输出 `IMPOSSIBLE`。

## 输入格式

```text
N M
routeId u v cost
...
```

## 输出格式

若无法连通：

```text
IMPOSSIBLE
```

若可以连通，输出两行：

```text
totalCost
routeId1 routeId2 ... routeIdN-1
```

第二行线路 ID 按字典序升序输出。

## 示例

输入：

```text
4 5
E1 0 1 4
E2 1 2 3
E3 2 3 2
E4 0 3 10
E5 0 2 5
```

输出：

```text
9
E1 E2 E3
```

## 复杂度建议

推荐使用 Kruskal 算法：按成本排序线路，并使用 Union-Find 判断加入一条线路是否会成环。复杂度通常为 `O(M log M)`。
