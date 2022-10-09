import java.io.*;

public class BOJ1992 {

    private static int[][] map;
    private static int N;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = c[j] - '0';
            }
        }
        divide(0, 0, N);
        System.out.println(sb);
    }

    private static void divide(int x, int y, int n) {
        if (isCheck(x, y, n)) {
            sb.append(map[x][y]);
            return;
        }
        int size = n / 2;
        sb.append("(");
        divide(x, y, size);
        divide(x, y + size, size);
        divide(x + size, y, size);
        divide(x + size, y + size, size);
        sb.append(")");

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
