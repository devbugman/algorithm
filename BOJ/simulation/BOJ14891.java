import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14891 {

    static int[][] map = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N극은 0, S극은 1
        // 10101111 
        // 01111101 
        // index = 0  = 1시 ,1번 = 3시, 2번  = 5시 3번  = 6시, 4번 7시 5번 9시 6번 11시 7번 12시 
        for (int i = 0; i < 4; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                map[i][j] = arr[j] - '0';
            }
        }

        int n = parseInt(br.readLine());
    }

    private static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
