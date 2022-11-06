import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11723 {

    /*
     * 비트마스킹 활용문제
     * 연산 수 3_000_000
     * cur |= (1 << x)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        int bit = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String option = st.nextToken();
            if ("all".equals(option)) {
                bit = (1 << 21) - 1;
            } else if ("empty".equals(option)) {
                bit = 0;
            } else {
                int num = Integer.parseInt(st.nextToken());
                if ("add".equals(option)) {
                    bit |= (1 << num);
                } else if ("check".equals(option)) {
                    sb.append((bit & (1 << num)) != 0 ? 1 : 0).append("\n");
                } else if ("remove".equals(option)) {
                    bit &= ~(1 << num);
                } else if ("toggle".equals(option)) {
                    bit ^= (1 << num);
                }
            }
        }
        System.out.println(sb);
    }
}
