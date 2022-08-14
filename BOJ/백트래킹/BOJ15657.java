import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15657 {
    
    static int N,M;
    static int[] map;
    static int[] arr = new int[10];
    static boolean[] visit = new boolean[10001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);
        solve(0, 0);
        System.out.println(sb);
    }

    static void solve(int k,int start){
        if(k == M){
            for(int i = 0; i < M; i++){
                sb.append(map[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < N; i++){
            arr[k] = i;
            solve(k+1,i);
        }
    }
}
