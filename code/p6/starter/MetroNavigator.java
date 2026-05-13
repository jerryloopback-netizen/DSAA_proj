import java.io.*;
import java.util.*;

public class MetroNavigator {
    static List<String> answerQueries(Map<String, List<String>> graph, List<String[]> queries) {
        Map<String, Integer> component = new HashMap<>();
        int componentId = 0;

        for (String station : graph.keySet()) {
            if (component.containsKey(station)) {
                continue;
            }

            Deque<String> stack = new ArrayDeque<>();
            stack.push(station);
            component.put(station, componentId);

            while (!stack.isEmpty()) {
                String current = stack.pop();
                for (String next : graph.get(current)) {
                    if (!component.containsKey(next)) {
                        component.put(next, componentId);
                        stack.push(next);
                    }
                }
            }

            componentId++;
        }

        List<String> result = new ArrayList<>();
        for (String[] query : queries) {
            Integer sourceComponent = component.get(query[0]);
            Integer targetComponent = component.get(query[1]);
            result.add(sourceComponent != null && sourceComponent.equals(targetComponent) ? "YES" : "NO");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(br.readLine().trim(), new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        List<String[]> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            queries.add(new String[] { st.nextToken(), st.nextToken() });
        }

        System.out.print(String.join("\n", answerQueries(graph, queries)));
    }
}
