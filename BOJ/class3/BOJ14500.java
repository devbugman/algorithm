import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {

    private static int[][] map;
    private static boolean[][] visit;
    private static int n, m;
    private static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    private static int max = 0;

    /*
     * Brute
     * 
     * ㅗ << 예외처리 해야한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, 0, 0);
                visit[i][j] = false;
                oh(0, i, j, map[i][j], 0);
            }
        }
        System.out.println(max);
    }

    // 정사각형 4개
    private static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isPosition(nx, ny) && !visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(nx, ny, sum + map[nx][ny], depth + 1);
                visit[nx][ny] = false;
            }
        }
    }

    // ㅗ 모양 점수 가져오기
    private static void oh(int s, int x, int y, int sum, int depth) {
        if (depth == 3) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = s; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isPosition(nx, ny)) {
                oh(i + 1, x, y, sum + map[nx][ny], depth + 1);
            }
        }
    }

    private static boolean isPosition(int x, int y) {
        return 0 <= x && 0 <= y && n > x && m > y;
    }
}
