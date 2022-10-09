import java.util.*;
import java.io.*;

public class BOJ1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int endTime = map[0][1];
        int count = 1;

        for (int i = 1; i < n; i++) {
            int start = map[i][0];
            if (start >= endTime) {
                endTime = map[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
