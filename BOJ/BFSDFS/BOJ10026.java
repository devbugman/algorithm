import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026{
    static int N;
    static char[][] maps,maps2;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    static Queue<Pair> q;
    static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        maps = new char[N][N];
        maps2 = new char[N][N];
        

        for(int i = 0; i < N; i++){
            String str= br.readLine();
            for(int j = 0; j < N; j++){
                maps[i][j] = str.charAt(j);
                maps2[i][j] = str.charAt(j);
                if(maps2[i][j] == 'G') maps2[i][j] = 'R';
            }
        }
        visit = new boolean[N][N];
        int cnt = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(!visit[i][j]){
                    bfs(i, j, maps);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        

        cnt = 0;
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j]){
                    bfs(i, j, maps2);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);



    }

    public static void bfs(int x, int y, char[][] arr){
        q = new LinkedList<>();
        char temp = arr[x][y];
        visit[x][y] = true;
        q.add(new Pair(x, y));

        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && ny>= 0 && nx < N && ny < N && !visit[nx][ny]){
                    if(arr[nx][ny] == temp){
                        visit[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}