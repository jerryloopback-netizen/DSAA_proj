# 5. Submission Interface

本文档整理自提交说明中的第五点，只保留与编码和提交接口相关的要求。编码时和提交前都应检查本页内容。

## 5.1 统一 Java 文件要求

每道题都指定固定文件名和固定主类名。文件名和 `public class` 名必须完全一致。

| 题号 | 题目名称 | 必须提交的文件 | 必须包含的 `public class` | 主要考点 |
| --- | --- | --- | --- | --- |
| P1 | Scenic Spot Sorting | `ScenicSorter.java` | `ScenicSorter` | 多关键字排序 |
| P2 | Check-in Queue | `CheckInScheduler.java` | `CheckInScheduler` | 队列 |
| P3 | Travel Note Lookup | `TravelNoteSearch.java` | `TravelNoteSearch` | 二分查找 |
| P4 | Stay Budget Ranking | `StayFinder.java` | `StayFinder` | 筛选、排序、比较器 |
| P5 | Transit Network Connector | `TransitConnector.java` | `TransitConnector` | 最小生成树、并查集 |
| P6 | Metro Connectivity Check | `MetroNavigator.java` | `MetroNavigator` | 图连通性、DFS/BFS |

示例：

```java
public class ScenicSorter {
    public static void main(String[] args) throws Exception {
        // Read input from System.in.
        // Print answer to System.out.
    }
}
```

请注意：

1. 不要写 `package` 声明。
2. 默认只能使用 Java 标准库。
3. 程序必须从 `System.in` 读取输入。
4. 程序必须向 `System.out` 输出答案。
5. 不要输出提示语、解释文字或调试信息。
6. 输出格式错误可能导致对应测试点不得分。

## 5.2 Starter Code

每道题页面都会提供题目资源 ZIP 下载，其中包含公开样例和 Java starter code。starter code 已经包含：

1. 必要的 `import`。
2. `main` 函数。
3. 输入读取代码。
4. 基本数据类或函数外框。
5. 需要补全的核心算法位置。

starter code 只是框架，不是标准答案。可以在框架基础上修改辅助数据结构，但必须保留题目要求的文件名、主类名、输入接口和输出接口。

## 5.3 本地运行示例

以 P1 为例，本地可以这样测试：

```text
javac ScenicSorter.java
java ScenicSorter < sample.in > my_output.out
```

然后比较 `my_output.out` 和样例输出。线上判题通常会忽略行尾多余空格和文件末尾多余空行，但不会忽略多余的调试输出。
