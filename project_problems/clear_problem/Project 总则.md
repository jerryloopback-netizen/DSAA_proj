# Project 总则

本 Project 以小组为单位完成 6 个旅行规划场景中的算法题。每道题都要求提交一个指定文件名的 Java 程序，程序从标准输入读取数据，并向标准输出打印答案。

## 你需要提交什么

| 题号 | 文件名 | 主类名 | 主要考点 |
| --- | --- | --- | --- |
| P1 | `ScenicSorter.java` | `ScenicSorter` | 多关键字排序 |
| P2 | `CheckInScheduler.java` | `CheckInScheduler` | 队列 |
| P3 | `TravelNoteSearch.java` | `TravelNoteSearch` | 二分查找 |
| P4 | `StayFinder.java` | `StayFinder` | 筛选、排序、比较器 |
| P5 | `TransitConnector.java` | `TransitConnector` | MST、Union-Find |
| P6 | `MetroNavigator.java` | `MetroNavigator` | 图连通性、DFS/BFS |

## 统一规则

1. 不要写 `package` 声明。
2. 只能使用 Java 标准库。
3. 不要输出提示语或调试信息。
4. 每道题的资源 ZIP 包含 public 样例和 starter code；starter code 已包含输入读取和函数外框，核心算法需要你们补全。
5. 截止前可以重复上传并在线检测；正式成绩以提交截止前每题最后一次提交为准。
6. 小组锁定后学生不能自行解锁，未满员也可以锁定，但锁定后不能再加入成员；特殊情况下老师可解除锁定并删除旧密钥。

## 在线检测与正式评分

在线检测使用 10 个 check 样例，目的是帮助你们调试。正式评分会使用隐藏 final 数据和一个性能压力样例。压力样例用于检查算法复杂度是否合理，时间阈值由官方参考解法在正式服务器上校准。

每题先得到百分制分数，再按老师设置的题目权重汇总：

```text
projectScore = sum(problemScore[i] * weight[i]) / sum(weight[i])
courseScore = projectScore / 100 * projectPoints
```

同一小组成员获得相同的最终 Project 分数。

## 推荐工作方式

先阅读题面和样例，确认输入输出格式；再下载 starter code，在本地用公开样例调试；最后上传到平台进行在线检测。对于大数据样例，优先使用课程中讲过的标准数据结构和 Java 标准库排序。
