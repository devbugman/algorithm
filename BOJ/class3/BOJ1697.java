import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1697 {

    private static int n, k;
    private static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        // n 0 ≤ N ≤ 100,000 m 0 ≤ K ≤ 100,000
        // 현재위치와 동생점이 같은경우
        if (n == k)
            System.out.println(0);
        else {
            System.out.println(bfs(n));
        }
    }

    private static int bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = 1;
        while (!q.isEmpty()) {
            int t = q.poll();
            if (t == k) {
                return visit[t] - 1;
            }

            if (t + 1 < 100001 && visit[t + 1] == 0) {
                visit[t + 1] = visit[t] + 1;
                q.offer(t + 1);
            }
            if (t - 1 >= 0 && visit[t - 1] == 0) {
                visit[t - 1] = visit[t] + 1;
                q.offer(t - 1);
            }
            if (t * 2 < 100001 && visit[t * 2] == 0) {
                visit[t * 2] = visit[t] + 1;
                q.offer(t * 2);
            }
        }
        return 0;
    }
}
