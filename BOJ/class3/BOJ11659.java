import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {

    /*
     * DP
     * dp를 활용 안하면 시간초과가 난다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int[] dp = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i] += dp[i - 1] + parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int k = parseInt(st.nextToken());
            int sum = dp[k] - dp[x - 1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
