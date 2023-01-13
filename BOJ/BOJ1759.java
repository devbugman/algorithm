import java.util.*;
import java.io.*;

public class BOJ1759 {
    private static int x, y;
    private static String[] map, code;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // 입력
        final var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = br.readLine().split(" ");
        code = new String[x];

        sb = new StringBuilder();
        Arrays.sort(map);
        dfs(0, 0);
        System.out.println(sb);

    }

    private static void dfs(int depth, int start) {
        if (depth == x) {
            if (check()) {
                for (String s : code) {
                    sb.append(s);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < y; i++) {
            code[depth] = map[i];
            dfs(depth + 1, i + 1);
        }
    }

    private static boolean check() {
        int vowel = 0;
        int consonant = 0;
        for (String alp : code) {
            
            if(isValid(alp)) {
                vowel++;
            } else {
                consonant++;
            }
        }
        return vowel>= 1 && consonant >= 2;
    }

    // {"a", "e", "i", "o", "u"};
    private static boolean isValid(String alp) {
        return "a".equals(alp) || "e".equals(alp) || "i".equals(alp) || "o".equals(alp)
                || "u".equals(alp);
    }
}
