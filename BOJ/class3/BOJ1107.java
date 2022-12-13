import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ1107 {

    private static int target;
    private static int m;
    private static final boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            breakButton(st);
        }

        System.out.println(solution());

    }

    private static void breakButton(final StringTokenizer st) {
        IntStream.range(0, m)
                .forEach(it -> breakButton(Integer.parseInt(st.nextToken())));
    }

    private static void breakButton(int buttonNumber) {
        broken[buttonNumber] = true;
    }

    private static int solution() {
        int answer = Math.abs(target - 100);
        for (int i = 0; i < 1_000_000; i++) {
            final var num = String.valueOf(i);
            final var len = num.length();
            if (!isBroken(num, len)) {
                final var min = Math.abs(target - i) + len;
                answer = Math.min(answer, min);
            }
        }
        return answer;
    }

    private static boolean isBroken(final String num, final int len) {
        for (int i = 0; i < len; i++) {
            if (broken[num.charAt(i) - '0']) {
                return true;
            }
        }

        return false;
    }

}
