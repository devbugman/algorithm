import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int x;
    int y;
    int z;
    int d;
    
    Pair(int x, int y, int z, int d){
        this.x = x;
        this.y = y;
        this.z = z;
        this.d = d;
    }
}

public class BOJ6593 {
    static int N,M,S;
    static char[][][] map;
    static boolean[][][] visit;
    static int[] dx = {1,0,0,-1,0,0},
                 dy = {0,1,0,0,-1,0},
                 dz = {0,0,1,0,0,-1};
    static Queue<Pair> q;
    static Pair end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            S = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(S == 0){
                break;
            }
            map = new char[S][N][M];
            visit = new boolean[S][N][M];
            q = new LinkedList<>();
            for(int i = 0; i < S; i++){
                for(int j = 0; j < N; j++){
                    String temp = br.readLine();
                    if(temp.equals("")) temp = br.readLine();
                    for(int t = 0; t < M; t++){
                        map[i][j][t] = temp.charAt(t);
                        if(map[i][j][t] == 'S'){
                            visit[i][j][t] = true;
                            q.offer(new Pair(i, j, t, 0));
                        }else if(map[i][j][t]=='E')end = new Pair(i, j, t, 0);
                    }
                }
            }
            bfs();

        }
    }
    private static void bfs(){
        while(!q.isEmpty()){
            Pair p = q.poll();
            int count = p.d;
            if(p.x == end.x && p.y == end.y && p.z == end.z){
                System.out.println("Escaped in " + count +" minute(s).");
                return;
            }
            for(int i = 0; i < dx.length; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];
                
                if(nx < 0 || ny < 0 || nz < 0 || nx >= S || ny >= N || nz >= M) continue;
                if(map[nx][ny][nz] == '#' || visit[nx][ny][nz]) continue;
                visit[nx][ny][nz] = true;
                q.offer(new Pair(nx, ny, nz, count + 1));
            }
        }
        System.out.println("Trapped!");
    }
}
