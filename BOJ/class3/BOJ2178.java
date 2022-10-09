import java.util.*;
import java.io.*;

public class BOJ2178 {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = c[j] - '0';
            }
        }
        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p[0];
                int ny = dy[i] + p[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 1 && !visit[nx][ny]) {
                        map[nx][ny] = map[p[0]][p[1]] + 1;
                        q.offer(new int[] { nx, ny });
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
}
