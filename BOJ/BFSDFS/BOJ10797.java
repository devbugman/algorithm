import java.util.Scanner;

public class BOJ10797 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (sc.nextInt() == num) {
                count++;
            }
        }
        System.out.println(count);
    }
}
