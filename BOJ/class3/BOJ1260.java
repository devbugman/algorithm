import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

    private static int[][] map;
    private static int n, m, v;
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        v = parseInt(st.nextToken());
        visit = new boolean[n + 1];
        map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = parseInt(st.nextToken());
            int e = parseInt(st.nextToken());
            map[s][e] = map[e][s] = 1;
        }
        dfs(v);
        sb.append("\n");
        visit = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    private static void dfs(int d) {
        visit[d] = true;
        sb.append(d).append(" ");
        for (int i = 1; i <= n; i++) {
            if (map[d][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int d) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(d);
        visit[d] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");
            for (int i = 1; i <= n; i++) {
                if (map[x][i] == 1 && !visit[i]) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
