import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {

    private static int n;
    private static char[][] redGreenColor;
    private static char[][] color;
    private static boolean[][] visit;
    private static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        redGreenColor = new char[n][n];
        color = new char[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                char readColor = c[j];
                redGreenColor[i][j] = readColor;
                color[i][j] = readColor;
                if (readColor == 'G') {
                    redGreenColor[i][j] = 'R';
                }
            }
        }

        int redGreenCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, redGreenColor[i][j], redGreenColor);
                    redGreenCount++;
                }
            }
        }

        visit = new boolean[n][n];
        int colorCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, color[i][j], color);
                    colorCount++;
                }
            }
        }

        System.out.println(colorCount + " " + redGreenCount);
    }

    private static void dfs(int x, int y, char color, char[][] map) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (isPosition(nx, ny)) {
                if (color == map[nx][ny] && !visit[nx][ny]) {
                    dfs(nx, ny, color, map);
                }
            }
        }
    }

    private static boolean isPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
