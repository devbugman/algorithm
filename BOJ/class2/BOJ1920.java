import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int result = binarySearch(Integer.parseInt(st.nextToken()));
            System.out.println(result);
        }
    }

    static int binarySearch(int k) {
        int left = 0;
        int right = map.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (k < map[mid]) {
                right = mid - 1;
            } else if (k > map[mid]) {
                left = mid + 1;
            } else if (k == map[mid]) {
                return 1;
            }
        }
        return 0;
    }
}
