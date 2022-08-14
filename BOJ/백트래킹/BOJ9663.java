import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
    
    static int count = 0;
    static int N;
    static boolean[] visit1 = new boolean[80];
    static boolean[] visit2 = new boolean[80];
    static boolean[] visit3 = new boolean[80];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solve(0);
        System.out.println(count);
    }

    static void solve(int cur){
        if(cur == N){
            count++;
            return;
        }
        for(int i = 0; i < N; i++){
            if(!visit1[i] && !visit2[cur+i] && !visit3[cur-i + N - 1]){
                visit1[i] = true;
                visit2[cur + i] = true;
                visit3[cur - i + N - 1] = true;
                solve(cur + 1);
                visit1[i] = false;
                visit2[cur + i] = false;
                visit3[cur - i + N - 1] = false;
            }
        }
    }
}
