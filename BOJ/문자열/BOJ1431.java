import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1431 {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Text> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new BOJ1431.Text(br.readLine()));
        }
        Collections.sort(list);
        for (Text text : list) {
            System.out.println(text.text);
        }
    }

    static class Text implements Comparable<Text> {
        int length, sum;
        String text;

        Text(String text) {
            this.length = text.length();
            this.text = text;
            this.sum = findNumber(text);
        }

        int findNumber(String text) {
            int sum = 0;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c >= '1' && c <= '9') {
                    sum += c - '0';
                }
            }
            return sum;
        }

        @Override
        public int compareTo(BOJ1431.Text o) {
            return this.length > o.length ? 1
                    : this.length < o.length ? -1
                            : this.sum > o.sum ? 1 : this.sum < o.sum ? -1 : this.text.compareTo(o.text);
        }

    }
}
