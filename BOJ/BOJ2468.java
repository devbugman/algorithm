import java.io.*;
import java.util.*;

public class BOJ2468 {
    private static int n;
    private static int[][] map;
    private static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    // bfs
    public static void main(final String[] args) throws IOException {
        // 입력
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int maxH = 0;
        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        int max = 0;
        for (int h = 1; h <= maxH; h++) {
            final var visited = new boolean[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] >= h) {
                        if (!visited[i][j]) {
                            dfs(i, j, visited, h);
                            count++;
                        }
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    private static void dfs(final int x, final int y, final boolean[][] visited, final int h) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            final var nx = dx[i] + x;
            final var ny = dy[i] + y;
            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(map[nx][ny] >= h && !visited[nx][ny]) {
                    dfs(nx, ny, visited, h);
                }
            } 
        }
    }

}
