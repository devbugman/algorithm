import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179 {
    static char[][] map;
    static Queue<Pair> q,fire;
    static int[] dx = {1,0,-1,0},dy = {0,1,0,-1};
    static int R,C;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        q = new LinkedList<>();
        fire = new LinkedList<>();
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J') q.add(new Pair(i, j, 0));
                else if(map[i][j] == 'F')fire.add(new Pair(i, j, 0));
            }
        }
        bfs();

    }
    public static void bfs(){
        while(!q.isEmpty()){
            int size = fire.size();
            for(int i = 0; i<size; i++){
                Pair p = fire.poll();

                for(int j = 0; j < 4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if(map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
                    map[nx][ny] = 'F';
                    fire.add(new Pair(nx, ny, p.x+1));
                }
            }

            size = q.size();
            for(int i=0; i<4; i++){
                Pair p = q.poll();
                for(int j = 0; j < 4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if(nx < 0 || ny < 0 || nx >= R || ny >= C){
                        System.out.println(p.d+1);
                        return;
                    }
                    if(map[nx][ny] == '#' || map[nx][ny] == 'F' || map[nx][ny] == 'J') continue;
                    map[nx][ny] = 'J';
                    q.add(new Pair(nx, ny, p.d + 1));
                }
            }
        }
    }
}
