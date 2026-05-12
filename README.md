# DSAA_proj

这是数据结构与算法课程项目工作区。项目围绕 6 个旅行规划场景题目展开，每题需要提交一个指定文件名和主类名的 Java 程序，从标准输入读取数据，并向标准输出打印答案。

## 目录说明

- `project_problems/clear_problem/`：已经清洗好的 Markdown 题面，去除了网页 UI、账号信息、提交面板等无关内容，可以直接阅读和用于开发。
- `project_problems/clear_problem/submissionInterface.md`：提交接口和编码规范摘要，编码时和提交前都需要检查。
- `project_problems/origin_problem/`：原始网页下载文件，包括 HTML 和浏览器保存的资源目录，仅作为备份。

## 题目简述

| 题号 | 题目 | 提交文件 | 主要考点 |
| --- | --- | --- | --- |
| P1 | Scenic Spot Sorting | `ScenicSorter.java` | 多关键字排序、筛选 |
| P2 | Check-in Queue | `CheckInScheduler.java` | 队列模拟 |
| P3 | Travel Note Lookup | `TravelNoteSearch.java` | 二分查找 |
| P4 | Stay Budget Ranking | `StayFinder.java` | 筛选、排序、比较器 |
| P5 | Transit Network Connector | `TransitConnector.java` | 最小生成树、Union-Find |
| P6 | Metro Connectivity Check | `MetroNavigator.java` | 图连通性、DFS/BFS |

## 使用建议

先阅读 `project_problems/clear_problem/Project 总则.md` 了解统一提交规则，再阅读 `project_problems/clear_problem/submissionInterface.md` 确认文件名、主类名、输入输出接口和本地运行方式，最后按题号阅读对应 Markdown 题面。开发时注意不要添加 `package` 声明，只使用 Java 标准库，并严格按照题面要求输出，避免输出调试信息。
