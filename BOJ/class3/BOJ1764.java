import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> lists = new ArrayList<>();
        String[] stArr = new String[n];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            stArr[i] = br.readLine();
            map.put(stArr[i], 0);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (map.get(stArr[i]) > 0) {
                lists.add(stArr[i]);
            }
        }
        Collections.sort(lists);
        System.out.println(lists.size());
        lists.forEach(it -> System.out.println(it));

    }
}
