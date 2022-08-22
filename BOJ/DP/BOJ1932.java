import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
    
    private static int[][] dp = new int[502][502];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 2][n + 2];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = map[1][1];
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1],dp[i][j - 1]) + map[i][j];
            }
        }
        // System.out.println(dp[n][n]);
        int max = 0;
        for(int i=1; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }
        System.out.println(max);
    }
}
