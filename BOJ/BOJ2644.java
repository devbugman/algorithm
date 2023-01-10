import java.io.*;
import java.util.*;

public class BOJ2644 {
    private static List<List<Integer>> list;
    private static boolean[] visit;
    private static int result = -1;

    public static void main(final String[] args) throws IOException {
        // 입력
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final var n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] degrees = new int[2];
        for (int i = 0; i < 2; i++) {
            degrees[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        visit = new boolean[n + 1];
        final var m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            final var x = Integer.parseInt(st.nextToken());
            final var y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(0, degrees[0], degrees[1]);
        System.out.println(result);
    }

    private static void dfs(final int cnt, final int start, final int end) {
        visit[start] = true;
        if (start == end) {
            result = cnt;
            return;
        }

        for (int i = 0; i < list.get(start).size(); i++) {
            final var node = list.get(start).get(i);
            if (!visit[node]) {
                dfs(cnt + 1, node, end);
            }
        }
    }
}
