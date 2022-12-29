import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class BOJ13305 {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final var n = Integer.parseInt(br.readLine());
        final var dist = new long[n];
        final var cost = new long[n];
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        final var price = getPrice(dist, cost, n);
        System.out.println(price);

    }

    private static long getPrice(final long[] dist, final long[] cost, final int size) {
        long price = 0L;
        long min = 2_000_000_000L;
        for(int i = 1; i < size; i++) {
            min = Math.min(min, cost[i - 1]);
            price += dist[i] * min;
        }
        return price;
    }


}