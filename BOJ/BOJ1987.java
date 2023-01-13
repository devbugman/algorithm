import java.io.*;
import java.util.*;

public class BOJ1987 {
    private static int r, c;
    private static char[][] map;
    private static final boolean[] visited = new boolean[100];
    private static final int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    private static int max = 0;

    public static void main(final String[] args) throws IOException {
        final var br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseUnsignedInt(st.nextToken());
        c = Integer.parseUnsignedInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            final char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = arr[j];
            }
        }
        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(final int x, final int y, final int cnt) {
        visited[map[x][y]] = true;
        max = Math.max(cnt, max);
        for (int i = 0; i < 4; i++) {
            final var nx = dx[i] + x;
            final var ny = dy[i] + y;

            if (nx < r && ny < c && nx >= 0 && ny >= 0) {
                if (!visited[map[nx][ny]]) {
                    dfs(nx, ny, cnt + 1);
                    visited[map[nx][ny]] = false;
                }
            }
        }
    }
}
