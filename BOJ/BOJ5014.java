import java.io.*;
import java.util.*;

public class BOJ5014 {
    private static int[] count;
    // bfs
    public static void main(final String[] args) throws IOException {
        // 입력
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        count = new int[a[0] + 1];
        System.out.println(bfs(a[0], a[1], a[2], a[3], a[4]));
    }

    // bfs q에 넣을 때 방문 해줘야 됨.
    private static String bfs(final int top, final int start, final int end, final int up, final int down) {
        final Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        count[start]++; 
        while(!q.isEmpty()) {
            final var curr = q.poll();
            if(curr == end) {
                return String.valueOf(count[curr] - 1);
            }

            if(curr + up <= top) {
                if(count[curr + up] == 0) {
                    count[curr + up] = count[curr] + 1;
                    q.offer(curr + up);
                }
            } 
            // 1
            if(curr - down > 0) {
                if(count[curr - down] == 0) {
                    count[curr - down] = count[curr] + 1;
                    q.offer(curr - down);
                }
            }
        }
        return "use the stairs";
    }
}
