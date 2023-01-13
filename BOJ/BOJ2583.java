import java.util.*;
import java.io.*;

public class BOJ2583 {
    private static int m, n, k;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(final String[] args) throws IOException {
        // 입력
        final var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = parseInt(st.nextToken());
        n = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            final int y = parseInt(st.nextToken());
            final int x = parseInt(st.nextToken());
            final int yy = parseInt(st.nextToken());
            final int xx = parseInt(st.nextToken());
            for (int j = x; j < xx; j++) {
                for (int z = y; z < yy; z++) {
                    map[j][z] = 1;
                }
            }
        }

        final List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] != 1 && !visited[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        System.out.println(list.size());
        for(final int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int bfs(final int x, final int y) {
        visited[x][y] = true;
        final Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        int sum = 1;
        while(!q.isEmpty()) {
            final Pair pair = q.poll();
            for(int i = 0; i < 4; i++) {
                final int nx = dx[i] + pair.x;
                final int ny = dy[i] + pair.y;
                if(nx >=0 && ny >= 0 && nx < m && ny < n) {
                    if(map[nx][ny] != 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        sum++;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }

        return sum;
    }

    private static int parseInt(final String str) {
        return Integer.parseInt(str);
    }

    private static class Pair {
        int x, y;
        Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
