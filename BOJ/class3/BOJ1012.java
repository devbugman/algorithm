import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ1012 {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            M = parseInt(st.nextToken());
            K = parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];
            count = 0;
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = parseInt(st.nextToken());
                int x = parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                continue;
            if (!visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}