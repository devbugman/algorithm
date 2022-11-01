import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            String[][] clothes = new String[x][2];
            for (int j = 0; j < x; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                clothes[j][0] = st.nextToken();
                clothes[j][1] = st.nextToken();
            }
            int result = solution(clothes);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        while (it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }

        return answer - 1;
    }

}
