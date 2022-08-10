import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ2559{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] map = new int[N];
        st = new StringTokenizer(br.readLine());
        int hap = 0;
        for(int i = 0; i < K; i++){
            map[i] = Integer.parseInt(st.nextToken());
            hap += map[i];
        }
        int max = hap;

        for(int i = K; i < N; i++){
            map[i] = Integer.parseInt(st.nextToken());
            hap += map[i];
            hap -= map[i - K];
            max = Math.max(max, hap);
        }
        System.out.println(max);
    }
}