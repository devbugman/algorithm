import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static int S,N,M;
    static int[][][] map;
    static boolean[][][] visit;
    static int[] dx = {1,0,0,-1,0,0},
                 dy = {0,1,0,0,-1,0},
                 dz = {0,0,1,0,0,-1};
    static Queue<Pair> q;

    static class Pair{
        int x,y,z;
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
          
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        map = new int[S][N][M];
        visit = new boolean[S][N][M];
        q = new LinkedList<>();
        for(int i = 0; i < S; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int z = 0; z < M; z++){
                    map[i][j][z] = Integer.parseInt(st.nextToken());
                    if(map[i][j][z] == 1){
                        visit[i][j][z] = true;
                        q.add(new Pair(i, j, z));
                    }
                }
                
            }
        }
        bfs();
    }

    static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < dx.length; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= S || ny >= N  || nz >= M) continue;
                if(map[nx][ny][nz] != 0 || visit[nx][ny][nz]) continue;
                map[nx][ny][nz] = map[p.x][p.y][p.z] + 1;
                visit[nx][ny][nz] = true;
                q.add(new Pair(nx, ny, nz));
            }
        }
        int result = 0;
        for(int i = 0; i < S; i++){
            for(int j = 0; j < N; j++){
                for(int z = 0; z < M; z++){
                    if(map[i][j][z] == 0){
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, map[i][j][z]);
                }
            }
        }
        System.out.println(result-1);
    }
}
