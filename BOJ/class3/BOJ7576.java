import java.io.*;
import java.util.*;

public class BOJ7576 {

    private static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N, M;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    private static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        q = new LinkedList<>();
        map = new int[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.offer(new Pair(i, j));
                    visit[i][j] = true;
                }
            }
        }
        bfs();
        System.out.println(getDate());
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (isArrayBounds(nx, ny))
                    continue;
                if (map[nx][ny] != 0 || visit[nx][ny])
                    continue;
                visit[nx][ny] = true;
                map[nx][ny] = map[p.x][p.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
    }

    private static int getDate() {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                result = Math.max(result, map[i][j]);
            }
        }
        return result - 1;
    }

    private static boolean isArrayBounds(int x, int y) {
        return x < 0 || y < 0 || x >= M || y >= N;
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
