import java.io.*;
import java.util.*;

public class TravelNoteSearch {
    static int findNote(List<String> noteIds, String target) {
        int left = 0;
        int right = noteIds.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = noteIds.get(mid).compareTo(target);
            if (cmp == 0) {
                return mid;
            }
            if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        List<String> noteIds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            noteIds.add(br.readLine().trim());
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String target = br.readLine().trim();
            int index = findNote(noteIds, target);
            out.append(target);
            if (index >= 0) {
                out.append(' ').append(index);
            } else {
                out.append(" NOT FOUND");
            }
            if (i + 1 < q) out.append('\n');
        }
        System.out.print(out);
    }
}
