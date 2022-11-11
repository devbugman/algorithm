import java.io.*;
import java.util.*;

public class BOJ17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> site = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String sizeName = st.nextToken();
            String password = st.nextToken();
            site.put(sizeName, password);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            String read = br.readLine();
            sb.append(site.get(read)).append("\n");
        }

        System.out.println(sb);
    }
}
