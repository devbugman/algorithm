import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 {
    
    // input 3 16
    // output 3 5 7 11 13
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] map = new boolean[M + 1];
        map[0] = map[1] = true;
        for(int i = 2; i <= Math.sqrt(M); i++){
            for(int j = 2; j <= M/i; j++){
                if(map[i*j]) continue;
                else map[i*j] = true;
            }
        }

        for(int i = N; i <= M; i++){
            if(!map[i])System.out.println(i);
        }
    }
}
