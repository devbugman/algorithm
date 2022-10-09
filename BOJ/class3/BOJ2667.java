import java.io.*;
import java.util.*;

public class BOJ2667 {

    private static int[][] map;
    private static boolean[][] visit;
    private static int N;
    private static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    private static int count = 0;
    private static int colorConut = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = c[j] - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    count++;
                    colorConut = 0;
                    dfs(i, j);
                    list.add(colorConut);
                }
            }
        }
        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        sb.append(count).append("\n");
        list.forEach(it -> sb.append(it).append("\n"));
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;
        colorConut++;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
