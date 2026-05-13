import java.io.*;
import java.util.*;

public class StayFinder {
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

    static class Place {
        String id;
        int price;
        int rating;
        int distance;

        Place(String id, int price, int rating, int distance) {
            this.id = id;
            this.price = price;
            this.rating = rating;
            this.distance = distance;
        }
    }

    static List<String> answerQuery(List<Place> places, int minPrice, int maxPrice, int maxDistance, int limit) {
        List<Place> candidates = new ArrayList<>();
        for (Place place : places) {
            if (place.price >= minPrice && place.price <= maxPrice && place.distance <= maxDistance) {
                candidates.add(place);
            }
        }

        candidates.sort(Comparator
                .comparingInt((Place place) -> place.rating).reversed()
                .thenComparingInt(place -> place.price)
                .thenComparingInt(place -> place.distance)
                .thenComparing(place -> place.id));

        List<String> result = new ArrayList<>();
        int count = Math.min(limit, candidates.size());
        for (int i = 0; i < count; i++) {
            result.add(candidates.get(i).id);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int q = fs.nextInt();
        List<Place> places = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            places.add(new Place(fs.next(), fs.nextInt(), fs.nextInt(), fs.nextInt()));
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int minPrice = fs.nextInt();
            int maxPrice = fs.nextInt();
            int maxDistance = fs.nextInt();
            int limit = fs.nextInt();
            List<String> answer = answerQuery(places, minPrice, maxPrice, maxDistance, limit);
            out.append(answer.isEmpty() ? "NONE" : String.join(" ", answer));
            if (i + 1 < q) out.append('\n');
        }
        System.out.print(out);
    }
}
