import java.util.*;
import java.io.*;

/**
 * 14503 로봇 청소기
 */
public class BOJ14503 {
    private static int n, m;
    private static int count = 1;
    private static int[][] map;
    /**
     * dx dy 방향
     */
    private static final int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };

    public static void main(final String[] args) throws IOException {
        // 입력
        final var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /**
         * 세로크기 n, 가로크기 m
         */
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        /**
         * 로봇 청소기 좌표와 총소할 방향
         */
        final var r = parseInt(st.nextToken());
        final var c = parseInt(st.nextToken());
        final var d = parseInt(st.nextToken());

        /**
         * 0은 청소 할 곳, 1은 벽
         */
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }
        dfs(r, c, d);
        System.out.println(count);
    }

    /**
     * 
     * @param r 좌표 r
     * @param c 좌표 c
     * @param d 청소기 방향 d
     */
    private static void dfs(final int r, final int c, final int d) {
        map[r][c] = 2;
        int nd = d;
        for (int i = 0; i < 4; i++) {
            nd = (nd + 3) % 4;
            final var nx = dx[nd] + r;
            final var ny = dy[nd] + c;

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 0) {
                    count++;
                    dfs(nx, ny, nd);
                    return;
                }
            }
        }

        final var back = (nd + 2) % 4;
        final var nx = dx[back] + r;
        final var ny = dy[back] + c;
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
            if (map[nx][ny] != 1) {
                dfs(nx, ny, nd);
            }
        }
    }

    private static int parseInt(final String str) {
        return Integer.parseInt(str);
    }
}
