import java.io.*;
import java.util.*;

public class BOJ2493 {
    public static void main(final String[] args) throws IOException {
        final var br = new BufferedReader(new InputStreamReader(System.in));
        final var n = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final Stack<Pair> s = new Stack<>();

        final StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            final var value = Integer.parseInt(st.nextToken());
            // push 6 9 5 7
            // pop 6 9
            // 0 0 2 2 4
            while (!s.isEmpty()) {
                if (value <= s.peek().value) {
                    sb.append(s.peek().index).append(" ");
                    break;
                }
                s.pop();
            }

            if (s.isEmpty()) {
                sb.append("0").append(" ");
            }
            s.push(new Pair(i, value));
        }

        System.out.println(sb.toString());
    }

    private static class Pair {
        int index;
        int value;

        Pair(final int index, final int value) {
            this.index = index;
            this.value = value;
        }
    }
}
