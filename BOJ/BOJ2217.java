import java.io.*;
import java.util.*;


public class BOJ2217 {
    public static void main(String[] args) throws IOException {
        // 입력
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final var n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        // // 내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        int max = -9;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, list.get(i - 1) * i);
        }
        System.out.println(max);
    }
}