import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int  i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + a[i];
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            System.out.println(dp[y] - dp[x - 1]);
        }
    }
}
