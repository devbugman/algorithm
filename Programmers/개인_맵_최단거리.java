import java.util.LinkedList;
import java.util.Queue;

public class 개인_맵_최단거리 {
    
    private class Pair{
        int x , y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {1,0,-1,0},dy = {0,1,0,-1};
    boolean[][] visit;
    int[][] maps;
    public int solution(int[][] maps) {
        this.maps = maps;
        int answer = 0;
        visit = new boolean[maps.length][maps[0].length];
        answer = bfs(0,0);
        return answer;
    }

    public int bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        visit[x][y] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                if(isCheck(nx, ny, maps))continue;
                if(visit[nx][ny] || maps[nx][ny] == 0) continue;
                maps[nx][ny] = maps[p.x][p.y] + 1;
                q.offer(new Pair(nx, ny));
                visit[nx][ny] = true;
            }
        }
        if(maps[maps.length - 1][maps[0].length - 1] == 1) return -1;
        return maps[maps.length - 1][maps[0].length - 1];
    }

    private boolean isCheck(int nx , int ny,int[][]maps){
        return nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length; 
    }

    public static void main(String[] args) {
        개인_맵_최단거리 s = new 개인_맵_최단거리();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}; // 11 
        // int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}; // - 1
        System.out.println(s.solution(maps));
    }
}
