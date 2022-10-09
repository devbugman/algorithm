import java.io.*;
import java.util.*;

public class BOJ2606 {

    private static int N, M;
    private static boolean[] visit;
    private static List<ArrayList<Integer>> list;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visit = new boolean[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1);
        System.out.println(count);
    }

    private static void dfs(int n) {
        visit[n] = true;

        for (int i : list.get(n)) {
            if (!visit[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
