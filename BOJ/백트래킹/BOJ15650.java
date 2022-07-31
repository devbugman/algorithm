import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {

    static int N;
    static int M;
    static int[] arr = new int[10];
    static boolean[] visit = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        solve(0);

    }

    static void solve(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        int temp = 1;
        if (k != 0)
            temp = arr[k - 1] + 1;
        for (int i = temp; i <= N; i++) {
            if (!visit[i]) {
                arr[k] = i;
                visit[i] = true;
                solve(k + 1);
                visit[i] = false;
            }

        }
    }
}
