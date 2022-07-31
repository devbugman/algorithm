import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {

    static int n, area;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Pair> q;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                    area++;
                }
            }
        }
        System.out.println(area);
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.offer(new Pair(x, y));
        visit[x][y] = true;
        int result = 0;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (map[nx][ny] == 0 || visit[nx][ny] || map[nx][ny] != 1)
                    continue;
                result++;
                visit[nx][ny] = true;
                q.offer(new Pair(nx, ny));
            }
        }
        list.add(result + 1);
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}