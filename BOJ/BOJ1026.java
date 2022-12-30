import java.io.*;
import java.util.*;


public class BOJ1026 {
    public static void main(String[] args) throws IOException {
        // 입력
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final var n = Integer.parseInt(br.readLine());
        
        // a의 수
        List<Integer> a = new ArrayList<>();
        // b의 수
        List<Integer> b = new ArrayList<>();
        // a 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
        // b 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        // a {0,1,1,1,6} b {8, 7, 3, 2, 1}
        // 정렬 오름차순
        Collections.sort(a);
        // 내림차순 정렬
        Collections.sort(b, Collections.reverseOrder());

        var result = 0;
        for (int i = 0; i < n; i++) {
            result += a.get(i) * b.get(i);
        }
        System.out.println(result);
    }
}