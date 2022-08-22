import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    
    private static int[][] dp = new int[45][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0][0] = 1;
        dp[1][1] = 1;
        for(int i = 2; i <= 40; i++){
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(dp[k][0] +" " + dp[k][1]);
        }
    }

    // private static void fibonacci(int n) {
    //     dp[0] = 0;
    //     dp[1] = 1;

    //     for(int i = 2; i <= n; i++){
    //         dp[i] = dp[i - 2] + dp[i - 1];
    //     }
    // }
}
