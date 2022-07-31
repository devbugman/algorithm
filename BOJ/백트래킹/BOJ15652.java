import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int n, m;
    static int[] arr = new int[10];
    static boolean[] vis = new boolean[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        solve(0);
        System.out.println(sb);
    }

    static void solve(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int temp = 1;
        if(k != 0) temp = arr[k - 1]; 

        for (int i = temp; i <= n; i++) {
            arr[k] = i;
            solve(k + 1);

        }
    }

}
