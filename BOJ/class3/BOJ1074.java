import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

    private static int N, R, C;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        R = parseInt(st.nextToken());
        C = parseInt(st.nextToken());

        // 2^n r = 3 c =1 11
        solve((int) Math.pow(2, N), R, C);
    }

    private static void solve(int n, int r, int c) {
        if (n == 1) {
            System.out.println(cnt);
            return;
        }
        int size = n / 2; // 분할
        // 1사분면
        // 3 < n = 2 &&
        if (r < size && c < size) {
            cnt += size * size * 0;
            solve(size, r, c);
        } else if (r < size && c < size + size) {
            cnt += size * size * 1;
            solve(size, r, c - size);
        } else if (r < size + size && c < size) {
            cnt += size * size * 2;
            solve(size, r - size, c);
        } else if (r < size + size && c < size + size) {
            cnt += size * size * 3;
            solve(size, r - size, c - size);
        }
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
