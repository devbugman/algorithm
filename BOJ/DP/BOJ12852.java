import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2];
        // 계산 배열
        int[] arr = new int[n + 2];

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            arr[i] = i - 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                arr[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                arr[i] = i / 3;
            }
        }
        System.out.println(dp[n]);
        int re = n;

        while (re >= 1) {
            System.out.print(re + " ");
            re = arr[re];
        }
    }
}
