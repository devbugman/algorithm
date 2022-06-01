import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ2667 {
    static int N, area = 0;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Pair> q;
    static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};    

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
            
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j]==1 && !visit[i][j]){
                    bfs(i, j);
                    area++;
                }
            }
        }
        System.out.println(area);
    }
    static void bfs(int x, int y){
        q = new LinkedList<>();
        q.add(new Pair(x, y));
        visit[x][y] = true;
        int result = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny] || map[nx][ny] == 0) continue;
                visit[nx][ny] = true;
                result++;
                q.add(new Pair(nx, ny));
            }
        }
        if(result > 0 )System.out.println(result + 1);
        
    }
}
