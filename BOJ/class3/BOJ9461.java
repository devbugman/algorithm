import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(dp[x]).append("\n");
        }

        System.out.println(sb);
    }
}
