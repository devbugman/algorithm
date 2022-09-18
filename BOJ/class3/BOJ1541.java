import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;

        String[] sub = str.split("-");

        for (int i = 0; i < sub.length; i++) {
            int sum = 0;
            String[] add = sub[i].split("\\+");
            for (int j = 0; j < add.length; j++) {
                sum += Integer.parseInt(add[j]);
            }
            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
