import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;




public class BOJ5427 {
    static int S,N,M,cnt;
    // static boolean[][] visit;
    // static char[][] map;
    static int[] dx= {1,0,-1,0}, dy = {0,1,0,-1};
    static char[][] map;
    static Queue<Pair>fire,q;


    static class Pair{
        int x,y,d;
        Pair(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        
        for(int s = 0; s < S; s++){
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]);
            N = Integer.parseInt(str[1]);
            System.out.println(N + " " + M);
            map = new char[N][M];

            q = new LinkedList<>();
            fire = new LinkedList<>();

            for(int i = 0; i<N; i++){
                String temp = br.readLine();
                for(int j = 0; j<M; j++){
                    map[i][j] = temp.charAt(j);
                    if(map[i][j] == '@'){
                        q.add(new Pair(i, j, 0));
                    }else if(map[i][j] == '*'){
                        fire.add(new Pair(i, j, 0));
                    }
                }

            }
            if(bfs())System.out.println(cnt);
            else System.out.println("IMPOSSIBLE");
        }
    }
    private static boolean bfs(){
        while(!q.isEmpty()){

            int size = fire.size();
            for(int i = 0; i < size; i++){
                Pair p = fire.poll();
                for(int x = 0; x < 4; x++){
                    int nx = p.x + dx[x];
                    int ny = p.y + dy[x];
                    if(nx<0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(map[nx][ny] == '#' || map[nx][ny] == '*')continue;
                    map[nx][ny] = '*';
                    fire.add(new Pair(nx, ny, p.d+1));
                }
            }

            size = q.size();
            for(int i = 0; i < size; i++){
                Pair p = q.poll();
                for(int x = 0; x < 4; x++){
                    int nx = p.x + dx[x];
                    int ny = p.y + dy[x];
                    if(nx<0 || ny < 0 || nx >= N || ny >= M){
                        cnt = p.d+1;
                        return true;
                    }
                    if(map[nx][ny] == '#' || map[nx][ny] == '*'|| map[nx][ny] == '@')continue;
                    map[nx][ny] = '@';
                    q.add(new Pair(nx, ny, p.d+1));
                }
            }
        }
        return false;
    }
}
