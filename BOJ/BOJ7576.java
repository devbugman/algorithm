import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static int N,M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    static Queue<Pair> q;

    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q = new LinkedList<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    q.add(new Pair(i, j));
                    visit[i][j] = true; 
                }
            }
        }
        bfs();
    }

    public static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
                if(map[nx][ny] != 0 || visit[nx][ny]) continue;
                visit[nx][ny] = true;
                map[nx][ny] = map[p.x][p.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                 result = Math.max(result, map[i][j]);
            }
        }
        System.out.println(result-1);

    }
}
