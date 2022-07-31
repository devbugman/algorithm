import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {

    static int N;
    static int M;
    static boolean[] visit = new boolean[10];
    static int[] map = new int[10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        solve(0);
    }

    static void solve(int k) {
        if (k == M) { // m개를 모두 택했으면
            for (int i = 0; i < M; i++) {
                System.out.print(map[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    map[k] = i;
                    solve(k + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
