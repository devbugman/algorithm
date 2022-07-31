import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
    
    static int N;
    static int R;
    static int C;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, N);
        
        dfs(size, R, C);
        

    }

    static void dfs(int size, int r,int c){
       
        if(size == 1) {
            System.out.println(cnt);
            return;
        }
        
        int n =  size/2;

        if(r < n && c < n){ // 1사분면
            cnt += n * n * 0;
            dfs(n, r, c);
        }else if(r < n && c < n + n){ // 2사분면
            cnt += n * n * 1;  
            dfs(n, r, c - n);
        }else if(r < n + n && c < n){ // 3 사분면
            cnt += n * n * 2;
            dfs(n, r - n, c);
        }else if(r < n + n && c < n + n){
            cnt += n * n * 3;
            dfs(n, r-n, c-n);
        }

        
    }
}
