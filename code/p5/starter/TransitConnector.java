import java.io.*;
import java.util.*;

public class TransitConnector {
    static class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            do {
                c = read();
            } while (c <= ' ' && c != -1);
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class Edge {
        String id;
        int from;
        int to;
        long cost;

        Edge(String id, int from, int to, long cost) {
            this.id = id;
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static class Result {
        boolean possible;
        long totalCost;
        List<String> edgeIds = new ArrayList<>();
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return false;
            }
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        }
    }

    static Result connect(int stopCount, List<Edge> routes) {
        Result result = new Result();
        if (stopCount <= 1) {
            result.possible = true;
            return result;
        }

        List<Edge> sortedRoutes = new ArrayList<>(routes);
        sortedRoutes.sort(Comparator
                .comparingLong((Edge edge) -> edge.cost)
                .thenComparing(edge -> edge.id));

        UnionFind uf = new UnionFind(stopCount);
        int selected = 0;
        for (Edge edge : sortedRoutes) {
            if (uf.union(edge.from, edge.to)) {
                result.totalCost += edge.cost;
                result.edgeIds.add(edge.id);
                selected++;
                if (selected == stopCount - 1) {
                    break;
                }
            }
        }

        result.possible = selected == stopCount - 1;
        return result;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        List<Edge> routes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            routes.add(new Edge(fs.next(), fs.nextInt(), fs.nextInt(), fs.nextInt()));
        }
        Result result = connect(n, routes);
        if (!result.possible) {
            System.out.print("IMPOSSIBLE");
            return;
        }
        Collections.sort(result.edgeIds);
        System.out.println(result.totalCost);
        System.out.print(String.join(" ", result.edgeIds));
    }
}
