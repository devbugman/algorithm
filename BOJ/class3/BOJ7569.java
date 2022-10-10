import java.io.*;
import java.util.*;

public class BOJ7569 {

    private static class Pair {
        int x, y, z;

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static int M, N, H;
    private static int[][][] map;
    private static boolean[][][] visit;
    private static Queue<Pair> q;
    private static int[] dx = { 1, 0, 0, -1, 0, 0 },
            dy = { 0, 1, 0, 0, -1, 0 },
            dz = { 0, 0, 1, 0, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = parseInt(st.nextToken());
        N = parseInt(st.nextToken());
        H = parseInt(st.nextToken());

        map = new int[H][N][M];
        visit = new boolean[H][N][M];
        q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int z = 0; z < M; z++) {
                    map[i][j][z] = parseInt(st.nextToken());
                    if (map[i][j][z] == 1) {
                        visit[i][j][z] = true;
                        q.offer(new Pair(i, j, z));
                    }
                }
            }
        }

        bfs();
        System.out.println(getDate());
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                int nz = dz[i] + p.z;

                if (isArrayBounds(nx, ny, nz))
                    continue;
                if (map[nx][ny][nz] != 0 || visit[nx][ny][nz])
                    continue;
                visit[nx][ny][nz] = true;
                map[nx][ny][nz] = map[p.x][p.y][p.z] + 1;
                q.offer(new Pair(nx, ny, nz));
            }
        }
    }

    private static int getDate() {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int z = 0; z < M; z++) {
                    if (map[i][j][z] == 0) {
                        return -1;
                    }
                    result = Math.max(result, map[i][j][z]);
                }
            }
        }
        return result - 1;
    }

    private static boolean isArrayBounds(int x, int y, int z) {
        return x < 0 || y < 0 || z < 0 || x >= H || y >= N || z >= M;
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
