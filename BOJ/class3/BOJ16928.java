import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {
    private static final int MAX_INDEX = 101;
    private static final int[] map = new int[MAX_INDEX];
    private static final boolean[] visit = new boolean[MAX_INDEX];
    private static int n;
    private static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            final var x = Integer.parseInt(st.nextToken());
            final var y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }
        bfs(1);
        
    }

    private static void bfs(final int index) {
        final int[] count = new int[MAX_INDEX];
        final Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        visit[index] = true;
        // 5를 굴려 6으로 이동한다.
        // 6을 굴려 12로 이동한다. 이 곳은 98로 이동하는 사다리가 있기 때문에, 98로 이동한다.
        // 2를 굴려 100으로 이동한다.
        while(!q.isEmpty()) {
            final var curr = q.poll();
            if(curr == 100) {
                System.out.println(count[curr]);
                return;
            }
            for(int i = 1; i < 7; i++) {
                final var node = curr + i;
                if(!isArrayOfRage(node)) continue;
                if(visit[node]) continue;
                visit[node] = true;
                
                if(map[node] != 0) {
                    if(!visit[map[node]]) {
                        q.offer(map[node]);
                        visit[map[node]] = true;
                        count[map[node]] = count[curr] + 1;
                    }
                }else {
                    q.offer(node);
                    count[node] = count[curr] + 1;
                }
            }
        }
    }

    private static boolean isArrayOfRage(int index) {
        return index < MAX_INDEX;
    }
}
// Test case 1
// 3 7
// 32 62
// 42 68
// 12 98x
// 95 13
// 97 25
// 97 25
// 97 25
// 93 37
// 79 27
// 75 19
// 49 47
// 67 17

// Test case 2
// 4 9
// 8 52
// 6 80
// 26 42
// 2 72
// 51 19
// 39 11
// 37 29
// 81 3
// 59 5
// 79 23
// 53 7
// 43 33
// 77 21