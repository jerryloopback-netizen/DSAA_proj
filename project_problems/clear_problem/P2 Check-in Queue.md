# P2 Check-in Queue

游客到达酒店前台办理登记。前台只有一条等待队伍，你需要根据操作记录维护队伍状态。

## 任务

给定 `M` 条操作：

- `JOIN travelerId`：旅客加入队尾。
- `SERVE`：服务队首旅客，并输出该旅客 ID；若队伍为空，输出 `EMPTY`。
- `FRONT`：查看队首旅客但不移除，并输出该旅客 ID；若队伍为空，输出 `EMPTY`。

请按操作顺序输出所有 `SERVE` 和 `FRONT` 操作的结果。

## 输入格式

```text
M
operation_1
operation_2
...
operation_M
```

`travelerId` 不含空格，大小写敏感。

## 输出格式

对每个 `SERVE` 或 `FRONT` 操作输出一行。

## 示例

输入：

```text
8
JOIN T01
JOIN T02
FRONT
SERVE
JOIN T03
SERVE
SERVE
SERVE
```

输出：

```text
T01
T01
T02
T03
EMPTY
```

解释：`FRONT` 只查看 `T01`，不移除；后续三次 `SERVE` 依次服务 `T01`、`T02`、`T03`，最后队伍为空。

## 复杂度建议

推荐使用 `ArrayDeque<String>`。所有操作应接近 `O(1)`，不要用 `ArrayList.remove(0)` 维护队首。
