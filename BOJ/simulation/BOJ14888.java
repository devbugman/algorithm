import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {

    private static int[] numbers;
    private static int n;
    private static int[] operation;
    private static boolean[] visited;
    private static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = parseInt(br.readLine());
        numbers = new int[n];
        visited = new boolean[4];
        operation = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        // + - * /
        for(int i = 0; i < 4; i++) {
            operation[i] = parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        make(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void make(int depth,int value) {
        if (depth == n) { // depth 3이면 ArrayIndexOutOfBoundsException 조심
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }
        for(int i = 0; i < 4; i++) {
            if(visited[i]) continue;
            if(operation[i] == 0) continue;
            operation[i]--;
            // visited[i] = true;
            switch (i) {
                case 0:
                    make(depth + 1, add(value, numbers[depth]));
                    break;
                case 1:
                    make(depth + 1, sub(value, numbers[depth]));
                    break;
                case 2:
                    make(depth + 1, mul(value, numbers[depth]));
                    break;
                case 3:
                    make(depth + 1, div(value, numbers[depth]));
                    break;
            }
            visited[i] = false;
            operation[i]++;
        }
    }

    private static int add(int x, int y) {
        return x + y;
    }

    private static int sub(int x, int y) {
        return x - y;
    }

    private static int mul(int x, int y) {
        return x * y;
    }

    private static int div(int x, int y) {
        int div = 0;
        if (x < 0) {
            x *= -1;
            div = (x / y) * -1;
        } else {
            div = x / y;
        }
        return div;
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
