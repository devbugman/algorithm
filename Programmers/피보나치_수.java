public class 피보나치_수 {

    private static int mod = 1234567;

    public int solution(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % mod;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 100000;
        피보나치_수 s = new 피보나치_수();
        System.out.println(s.solution(n));
    }
}
