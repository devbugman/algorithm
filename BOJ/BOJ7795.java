import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] n = new int[a];
            int[] m = new int[b];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n.length; j++) {
                n[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m.length; j++) {
                m[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(m);
            int count = 0;
            for (int j = 0; j < a; j++) {
                count += binarySearch(n[j], m, b);
            }
            System.out.println(count);

        }
    }

    static int binarySearch(int x, int[] m, int b) {
        int left = 0, right = b - 1;
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (m[mid] < x) {// n[j]크기 보다 작으면
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx + 1;
    }

}
