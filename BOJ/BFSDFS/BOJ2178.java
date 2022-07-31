import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ2178 {

    static int N, M;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    static Queue<Pair> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        vis = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';    
            }
        }
        bfs(0,0);
        System.out.println(map[N - 1][M - 1]);
    }
    
    static void bfs(int x, int y){
        q = new LinkedList<>();
        vis[x][y] = true;
        q.offer(new Pair(x, y));
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == 0 || vis[nx][ny])continue;
                q.offer(new Pair(nx, ny));
                vis[nx][ny] = true;
                map[nx][ny] = map[p.x][p.y] + 1;
            }
        }
    }

    static class Pair {
        int x, y, d;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}