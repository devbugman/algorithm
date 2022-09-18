import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1620 {

    private static int n, m; // 포켓먼 수, 맞춰야 하는 문제의 개수 M

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String[] pokemon = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(name, i);
            pokemon[i] = name;
        }
        // N과 M은 1보다 크거나 같고, 100,000 이하
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (isNumber(s)) {
                sb.append(pokemon[Integer.parseInt(s)]);
            } else {
                int idx = map.get(s);
                sb.append(idx);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isNumber(String s) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(s, pos);
        return s.length() == pos.getIndex();
    }

    static class Pokemon {
        int idx;
        String name;

        Pokemon(int idx, String name) {
            this.idx = idx;
            this.name = name;
        }
    }
}
