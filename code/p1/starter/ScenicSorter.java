import java.io.*;
import java.util.*;

public class ScenicSorter {
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

    static class Spot {
        String id;
        int rating;
        int distance;
        int cost;
        int duration;

        Spot(String id, int rating, int distance, int cost, int duration) {
            this.id = id;
            this.rating = rating;
            this.distance = distance;
            this.cost = cost;
            this.duration = duration;
        }
    }

    static List<String> chooseSpots(List<Spot> spots, int k, int maxCost, int maxDuration) {
        List<Spot> candidates = new ArrayList<>();
        for (Spot spot : spots) {
            if (spot.cost <= maxCost && spot.duration <= maxDuration) {
                candidates.add(spot);
            }
        }

        candidates.sort(Comparator
                .comparingInt((Spot spot) -> spot.rating).reversed()
                .thenComparingInt(spot -> spot.distance)
                .thenComparingInt(spot -> spot.cost)
                .thenComparing(spot -> spot.id));

        List<String> result = new ArrayList<>();
        int limit = Math.min(k, candidates.size());
        for (int i = 0; i < limit; i++) {
            result.add(candidates.get(i).id);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int q = fs.nextInt();
        List<Spot> spots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            spots.add(new Spot(fs.next(), fs.nextInt(), fs.nextInt(), fs.nextInt(), fs.nextInt()));
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            List<String> answer = chooseSpots(spots, fs.nextInt(), fs.nextInt(), fs.nextInt());
            out.append(answer.isEmpty() ? "NONE" : String.join(" ", answer));
            if (i + 1 < q) out.append('\n');
        }
        System.out.print(out);
    }
}
