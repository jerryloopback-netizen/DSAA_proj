import java.io.*;
import java.util.*;

public class CheckInScheduler {
    static class Operation {
        String type;
        String travelerId;

        Operation(String type, String travelerId) {
            this.type = type;
            this.travelerId = travelerId;
        }
    }

    static List<String> process(List<Operation> operations) {
        Queue<String> queue = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        for (Operation operation : operations) {
            if ("JOIN".equals(operation.type)) {
                queue.offer(operation.travelerId);
            } else if ("SERVE".equals(operation.type)) {
                result.add(queue.isEmpty() ? "EMPTY" : queue.poll());
            } else if ("FRONT".equals(operation.type)) {
                result.add(queue.isEmpty() ? "EMPTY" : queue.peek());
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().trim());
        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            String travelerId = st.hasMoreTokens() ? st.nextToken() : "";
            operations.add(new Operation(type, travelerId));
        }

        List<String> answer = process(operations);
        System.out.print(String.join("\n", answer));
    }
}
