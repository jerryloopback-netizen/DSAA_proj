# P6 Metro Connectivity Check

最后，游客需要确认两个地铁站之间是否属于同一个可达区域。你不需要输出具体路线，只需要回答是否连通。

## 任务

给定 `N` 个站点、`M` 条无向连接和 `Q` 个查询。对于每个查询 `source target`：

- 如果可以从 `source` 到达 `target`，输出 `YES`。
- 否则输出 `NO`。

## 输入格式

```text
N M Q
stationName
...
stationA stationB
...
source target
...
```

接下来 `N` 行是站点名，`M` 行是无向连接，`Q` 行是查询。

## 输出格式

每个查询输出一行：

```text
YES
```

或：

```text
NO
```

## 示例

输入：

```text
5 3 3
A
B
C
D
E
A B
B C
D E
A C
A E
D E
```

输出：

```text
YES
NO
YES
```

## 复杂度建议

可以先用 DFS/BFS 为每个连通块编号，再按编号回答查询。也可以使用 Union-Find。压力样例查询较多，建议避免每个查询都重新遍历整张图。
