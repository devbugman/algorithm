import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1012 {
    
    static int N,M,K;
    static int[][] map;
    static boolean[][] vis;
    static int[] dx = {1,0,-1,0},dy = {0,1,0,-1};
    static int count;
    static Queue<Pair> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            vis = new boolean[N][M];
            count = 0;
            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for(int j = 0; j < N; j++){
                for(int y = 0; y < M; y++){
                    if(map[j][y] == 1 && !vis[j][y]){
                        bfs(j, y);
                    }
                }
            }
            System.out.println(count);

        }
    }

    static void bfs(int x, int y){
        q = new LinkedList<>();
        vis[x][y] = true;
        q.offer(new Pair(x, y));
        count++;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(vis[nx][ny] || map[nx][ny] != 1) continue;
                q.offer(new Pair(nx, ny));
                vis[nx][ny] = true;
            }
        }
    }

    static class Pair{
        int x,y;

        Pair(int x, int y){
            this.x = x;
            this.y = y; 
        }
    }
}
