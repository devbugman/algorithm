import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17626 {

    /*
     * DP
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }
}
/**
 * dp[1] = 1^2 = 1개
 * dp[2] = 1^2 + 1^2 = 2개
 * dp[3] = 1^2 + 1^2 + 1^2 = 3개
 * dp[4] = 2^2 = 1개
 * dp[5] = 2^2 + 1^2 = 2개
 * dp[6] = 2^2 +1^2 + 1^2 = 3개
 * dp[7] = 2^2 +1^2 + 1^2 + 1^2 = 4개
 * dp[8] = 2^2 +2^2 = 2개
 * dp[9] = 3^2 = 1개
 */
