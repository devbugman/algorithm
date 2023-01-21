import java.io.*;
import java.util.*;

public class BOJ14889 {
    private static int n;
    private static int min;
    private static boolean[] visited;
    private static int[][] map;

    public static void main(final String[] args) throws IOException {
        final var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 1);
        System.out.println(min);
    }

    private static void backTracking(final int depth, final int start) {
        if (depth == n / 2) {
            int startTeam = 0;
            int linkTeam = 0;
            for (int i = 1; i <= n - 1; i++) {
                for (int j = i; j <= n; j++) {
                    if (visited[i] && visited[j])
                        startTeam += map[i][j] + map[j][i];
                    if (!visited[i] && !visited[j])
                        linkTeam += map[i][j] + map[j][i];
                }
            }
            final int result = Math.abs(startTeam - linkTeam);
            min = Math.min(min, result);
            return;
        }

        for (int i = start; i <= n; i++) {
            visited[i] = true;
            backTracking(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}