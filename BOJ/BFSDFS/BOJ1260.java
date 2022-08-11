import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    // N = 정점의 개수, M = 간선의 개수 V = 탐색을 시작번호
    static int N,M,V;
    static int[][] map;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list; // list로 인접행렬 로 풀려했으나 2번째 테스트케이스 실패 
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        visit = new boolean[N + 1];
        map = new int[N + 1][N + 1];        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            map[idx][edge] = map[edge][idx] = 1;
        }

        dfs(V);
        sb.append("\n");
        visit = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    private static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visit[n] = true;
        while(!q.isEmpty()){
            int nx = q.poll();
            sb.append(nx).append(" ");
            for(int i = 1; i <= N; i++){
                if(!visit[i] && map[nx][i] == 1){
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }

    }

    private static void dfs(int n){
        visit[n] = true;
        sb.append(n).append(" ");
        for(int i = 1; i <= N; i++){
            if(!visit[i] && map[n][i] == 1){
                dfs(i);
            }
        }
    }
}