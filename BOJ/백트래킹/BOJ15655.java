import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {

    static int N, M;
    static boolean[] visit = new boolean[100001];
    static int[] map;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N];
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        solve(0,0);
    }

    static void solve(int k,int start){
        if(k == M){
            for(int i = 0; i < M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        int temp = 0;

        for(int i = start; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[k] = map[i];
                solve(k + 1,i);
                visit[i] = false;
            }
        }       
    }
}