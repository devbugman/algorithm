import java.io.*;

public class BOJ5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        int cnt = 0;
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            if (c[i - 1] == 'I' && c[i] == 'O' && c[i + 1] == 'I') {
                cnt++;
                i++;
            } else {
                cnt = 0;
            }

            if (cnt >= n) {
                res++;
            }
        }
        System.out.println(res);
    }
}
