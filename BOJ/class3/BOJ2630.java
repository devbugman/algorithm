import java.io.*;
import java.util.StringTokenizer;

public class BOJ2630 {

    private static int[][] map;
    private static int[] count = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, n);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 2; i++) {
            sb.append(count[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void divide(int x, int y, int n) {
        if (isCheck(x, y, n)) {
            count[map[x][y]]++;
            return;
        }
        int size = n / 2;
        divide(x, y, size);
        divide(x, y + size, size);
        divide(x + size, y, size);
        divide(x + size, y + size, size);
    }

    private static boolean isCheck(int x, int y, int size) {
        int color = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (color != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
