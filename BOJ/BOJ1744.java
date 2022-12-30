import java.io.*;
import java.util.*;

public class BOJ1744 {
    public static void main(String[] args) throws IOException {
        // 입력
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final var n = Integer.parseInt(br.readLine());
        // 합이 최대
        // 음수 * 음수
        // 1은 항상 더하기
        // 홀수 입력 처리 ? 
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            final var target = Integer.parseInt(br.readLine());
            // 양수
            if (target > 0) 
                plus.offer(target);
            else  // 0 음수 
                minus.offer(target);
        }
        long sum = 0;
        // -5 * -3 +  -1 * 0 
        // 크기 2이상 
        while (minus.size() >= 2) {
            int n1 = minus.poll();
            int n2 = minus.poll();
            sum += n1 * n2;
        }
        
        while (plus.size() >= 2) {
            int n1 = plus.poll();
            int n2 = plus.poll();
            // 두 숫자중 1이 있다면 더한다.
            sum += getResultNumber(n1, n2);
        }

        // 만약 숫자가 남아있다면 
        if (!minus.isEmpty()) {
            sum += minus.poll();
        }

        if (!plus.isEmpty()) {
            sum += plus.poll();
        }
        System.out.println(sum);
    }

    private static int getResultNumber(int n1, int n2) {
        if (isNumberOfOne(n1, n2)) {
            return n1 + n2;
        }
        return n1 * n2;
    }
    private static boolean isNumberOfOne(int n1, int n2) {
        return n1 == 1|| n2 == 1;
    }

}