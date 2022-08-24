import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {
    
    private static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    private static int N, M; 
    private static int[][] map;
    private static boolean[][][] visit; //  상태 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            String numbers = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = numbers.charAt(j) - '0';
            }
        }
        int result = bfs(0, 0);
        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y, 1, false));
        visit[x][y][0] = true;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int xx = p.x;
            int yy = p.y;
            int dist = p.dist;
            Boolean status = p.status;
            if(xx == N - 1 && yy == M - 1) {
                return dist;
            }

            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + xx;
                int ny = dy[i] + yy;
                if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 0 && !status && !visit[nx][ny][0]) {
                    visit[nx][ny][0] = true;
                    q.offer(new Pair(nx, ny, dist + 1, false));
                }else if(map[nx][ny] == 0 && status && !visit[nx][ny][1]) {
                    // 벽 1회 사용시 0번재
                    visit[nx][ny][1] = true;
                    q.offer(new Pair(nx, ny, dist + 1, true));
                }else if(map[nx][ny] == 1 && !status) { // 벽이면서 벽뚫은적이 없다면
                    visit[nx][ny][1] = true;
                    q.offer(new Pair(nx, ny, dist + 1, true));
                }
            }
        }
        return -1;
    }

    private static class Pair {
        int x; 
        int y; 
        int dist;
        boolean status; // 벽 1회만 뚤을수 있기 때문에 .

        Pair(int x, int y, int dist, boolean status) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.status = status;
        }
    }
}
