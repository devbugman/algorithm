import java.io.*;
import java.util.*;

public class BOJ15686 {

    private static final List<Point> house = new ArrayList<>();
    private static final List<Point> shop = new ArrayList<>();
    private static int n;
    private static int m;
    private static boolean[] cheked;
    private static int result;

    public static void main(final String[] args) throws IOException {
        final var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                final var target = parseInt(st.nextToken());
                if (target == 1) {
                    house.add(new Point(i, j));
                } else if (target == 2) {
                    shop.add(new Point(i, j));
                }
            }
        }
        result =  Integer.MAX_VALUE;
        cheked = new boolean[shop.size()];
        dfs(0, 0);
        System.out.println(result);

    }

    private static void dfs(final int start, final int depth) {
        if (depth == m) {
            int res = 0;
            for (int i = 0; i < house.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < shop.size(); j++) {
                    if(cheked[j]) {
                        min = Math.min(min, getDistince(house.get(i), shop.get(j)));
                    }
                }
                res += min;
            }
            result = Math.min(res, result);
            return;
        }
        for (int i = start; i < shop.size(); i++) {
            cheked[i] = true;
            dfs(i + 1, depth + 1);
            cheked[i] = false;
        }
    }

    private static int parseInt(final String st) {
        return Integer.parseInt(st);
    }

    private static int getDistince(final Point house, final Point shop) {
        return Math.abs(house.x - shop.x) + Math.abs(house.y - shop.y);
    }

    private static final class Point {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

    }
}
