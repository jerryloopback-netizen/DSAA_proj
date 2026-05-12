# DSAA Project 题目分析

## P1 Scenic Spot Sorting — 多关键字排序

### 题面概述

给定 N 个景点（含 id、rating、distance、cost、duration 属性）和 Q 个查询。每个查询指定 K、maxCost、maxDuration，要求筛选出满足 cost 和 duration 限制的景点，按多关键字排序后输出前 K 个 ID。

### 实现思路

1. 读入所有景点信息存入列表。
2. 对每个查询：
   - 遍历景点列表，筛选满足 `cost <= maxCost && duration <= maxDuration` 的候选。
   - 对候选列表使用自定义 Comparator 排序：rating 降序 → distance 升序 → cost 升序 → id 字典序升序。
   - 取前 K 个输出，若候选为空输出 `NONE`。

### 注意事项

- 排序规则有 4 级，Comparator 链式比较时注意方向（降序用 `b - a`，升序用 `a - b`，字符串用 `compareTo`）。
- 压力样例 N 较大，必须使用 `Arrays.sort` / `Collections.sort`（O(N log N)），不能手写冒泡。
- 每个查询独立筛选，不要修改原始列表。
- 输出格式：同一行空格分隔，无尾随空格。

---

## P2 Check-in Queue — 队列

### 题面概述

模拟酒店前台排队：支持 JOIN（入队）、SERVE（出队并输出）、FRONT（查看队首但不出队）三种操作。队空时 SERVE/FRONT 输出 `EMPTY`。

### 实现思路

1. 使用 `ArrayDeque<String>` 作为队列。
2. 逐行读取操作：
   - `JOIN travelerId`：`queue.offer(travelerId)`
   - `SERVE`：队空输出 EMPTY，否则 `queue.poll()` 并输出
   - `FRONT`：队空输出 EMPTY，否则 `queue.peek()` 并输出

### 注意事项

- 不要用 `ArrayList.remove(0)`，那是 O(N) 操作，压力样例会超时。
- `travelerId` 大小写敏感，原样存储和输出。
- 注意区分 SERVE（移除）和 FRONT（不移除）。
- 输入解析时 JOIN 后面跟一个空格再跟 ID，用 `split(" ", 2)` 或 substring 提取。

---

## P3 Travel Note Lookup — 二分查找

### 题面概述

给定按字典序升序排列的 N 个 noteId，对 Q 个查询判断是否存在：存在输出 0-based 下标，不存在输出 `NOT FOUND`。

### 实现思路

1. 将 N 个 noteId 存入 `String[]` 数组（已有序）。
2. 对每个查询使用二分查找：
   - 手写二分或使用 `Arrays.binarySearch`。
   - 找到则输出 `queryId index`，未找到输出 `queryId NOT FOUND`。

### 注意事项

- 字符串比较用 `compareTo`，不能用 `==`。
- 输出格式是 `queryId 位置` 或 `queryId NOT FOUND`，注意中间有空格。
- 如果用 `Arrays.binarySearch`，返回负值表示未找到。
- 压力样例 Q 很大，线性扫描 O(NQ) 会超时，必须二分 O(Q log N)。

---

## P4 Stay Budget Ranking — 筛选 + 排序 + 比较器

### 题面概述

给定 N 个地点（id、price、rating、distance）和 Q 个查询。每个查询指定 minPrice、maxPrice、maxDistance、K，筛选满足价格区间和距离限制的地点，按多关键字排序后输出前 K 个。

### 实现思路

1. 读入所有地点信息。
2. 对每个查询：
   - 筛选：`minPrice <= price <= maxPrice && distance <= maxDistance`
   - 排序：rating 降序 → price 升序 → distance 升序 → id 字典序升序
   - 取前 K 个输出，候选为空输出 `NONE`。

### 注意事项

- 与 P1 类似但筛选条件不同（价格是区间筛选，多了 minPrice）。
- 排序第二关键字是 price（不是 distance），注意和 P1 区分。
- 同样避免 O(N^2) 排序，使用标准库。
- 每个查询独立，不要复用上一次的筛选结果。

---

## P5 Transit Network Connector — MST / Kruskal + Union-Find

### 题面概述

给定 N 个点（0..N-1）和 M 条带权无向边（含 routeId），选择若干边使所有点连通且总成本最小。输出总成本和选中边的 routeId（字典序）。不可连通输出 `IMPOSSIBLE`。

### 实现思路

1. 读入所有边，按 cost 升序排序（Kruskal）。
2. 初始化 Union-Find（大小 N）。
3. 遍历排序后的边：
   - 若 u、v 不在同一集合，合并并记录该边。
   - 当选中 N-1 条边时提前终止。
4. 若最终选中边数 < N-1，输出 `IMPOSSIBLE`。
5. 否则输出总 cost，以及选中边的 routeId 按字典序排序后空格分隔输出。

### 注意事项

- Union-Find 需要路径压缩 + 按秩合并以保证效率。
- cost 相同时 Kruskal 选哪条都行（题目只要求最小总成本），但输出的 routeId 要按字典序排序。
- 点编号是 0..N-1 整数，但边有字符串 routeId。
- 注意 `IMPOSSIBLE` 的判断：选中边数 < N-1。

---

## P6 Metro Connectivity Check — 图连通性 / DFS / BFS / Union-Find

### 题面概述

给定 N 个站点（字符串名称）、M 条无向边和 Q 个查询。每个查询问两个站点是否连通，输出 `YES` 或 `NO`。

### 实现思路

**方案 A：预处理连通分量编号**
1. 建图（邻接表，站点名 → 编号映射）。
2. DFS/BFS 遍历所有节点，为每个连通分量分配编号。
3. 查询时比较两个站点的分量编号是否相同。

**方案 B：Union-Find**
1. 站点名映射为整数编号。
2. 对每条边执行 union 操作。
3. 查询时判断 find(source) == find(target)。

### 注意事项

- 站点名是字符串，需要用 `HashMap<String, Integer>` 做名称到编号的映射。
- 压力样例 Q 很大，不能每次查询都重新 BFS/DFS，必须预处理。
- Union-Find 方案代码更简洁，且天然支持高效查询。
- 注意输入格式：先 N 行站点名，再 M 行边，再 Q 行查询。

---

## 总体建议

| 题号 | 核心数据结构/算法 | 预估难度 |
|------|-------------------|----------|
| P1 | Comparator + sort | ★★☆ |
| P2 | ArrayDeque | ★☆☆ |
| P3 | Binary Search | ★☆☆ |
| P4 | Comparator + sort | ★★☆ |
| P5 | Kruskal + Union-Find | ★★★ |
| P6 | Union-Find / BFS | ★★☆ |

建议实现顺序：P2 → P3 → P1 → P4 → P6 → P5（由易到难）。

所有题目统一要求：
- 不写 `package` 声明
- 只用 Java 标准库
- 不输出提示语或调试信息
- 使用 `Scanner` 或 `BufferedReader` 读取标准输入，`System.out.println` 输出
