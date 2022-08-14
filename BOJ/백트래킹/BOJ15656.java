import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15656 {

    static int N, M;
    static int[] map;
    static int[] arr = new int[10];
    static boolean[] visit = new boolean[10001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());// 전역으로 new int[10]초기화와 new int[N]차이가 뭐지 글로벌로했을땐 값이 0으로만 값이 들어간다.
        }

        Arrays.sort(map);
        solve(0);
        System.out.println(sb);
    }

    static void solve(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(map[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[k] = i;
            solve(k + 1);
        }
    }
}
