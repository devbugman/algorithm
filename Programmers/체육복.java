import java.util.*;

public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 2];
        Arrays.fill(arr, 1);

        // 도난 당한
        for (int i : lost) {
            arr[i]--;
        }
        // reserve
        for (int i : reserve) {
            arr[i]++;
        }

        for (int i = 0; i < arr.length; i++) {
            // 기준은 여벌이 남는기준으로 하였음
            // 왼쪽
            if (arr[i] == 2 && arr[i - 1] == 0) {
                arr[i]--;
                arr[i - 1]++;
            }

            if (arr[i] == 2 && arr[i + 1] == 0) {
                arr[i]--;
                arr[i + 1]++;
            }
        }

        for (int i : arr) {
            if (i > 0)
                answer++;
        }

        return answer - 2;
    }

    public static void main(String[] args) {
        체육복 s = new 체육복();

        int n = 5;
        int[] lost = { 2, 4 }; // 체육복이 없는 학생
        int[] reserve = { 3 }; // 체육복 여벌이 남는 학생

        int answer = s.solution(n, lost, reserve);
        System.out.println(answer);
    }
}
