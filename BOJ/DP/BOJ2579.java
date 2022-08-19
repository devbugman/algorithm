import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
            sum += stairs[i];
        }
        // 2이하라면
        if(n <= 2){
            System.out.println(sum);
            return;
        }

        dp[1] = stairs[1]; dp[2] = stairs[2]; dp[3] = stairs[3];
        for(int i =4; i <= n - 1; i++){
            dp[i] = Integer.min(dp[i - 3], dp[i - 2]) + stairs[i];
        }
        
        System.out.println(sum - Integer.min(dp[n -1],dp[n - 2]));
    }
}
