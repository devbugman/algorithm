import java.io.*;
import java.util.*;

public class BOJ11501 {
    public static void main(String[] args) throws IOException {
        // 입력
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final var n = Integer.parseInt(br.readLine());
        final var result = new long[n];
        for (int i = 0; i < n; i++) {
            var t = Integer.parseInt(br.readLine());
            var stock = new int[t];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < t; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }

            result[i] = getStockProfit(t, stock);
        }
        StringBuilder sb = extracted(result);
        System.out.println(sb);
    }

    private static StringBuilder extracted(final long[] result) {
        StringBuilder sb = new StringBuilder();
        for (long stock : result) {
            sb.append(stock).append("\n");
        }
        return sb;
    }

    private static long getStockProfit(int t, int[] stock) {
        var sum = 0l;
        var max = -1;
        for (int i = t - 1; i >= 0; i--) {
            if(stock[i] > max) {
                max = stock[i];
            } else {
                sum += (max - stock[i]);
            }
        }
        return sum;
    }
}