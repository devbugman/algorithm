import java.util.*;

public class 모의고사 {

    public int[] solution(int[] answers) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        System.out.println(a[0 % a.length]);

        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) {
                score[0]++;
            }
            if (answers[i] == b[i % b.length]) {
                score[1]++;
            }
            if (answers[i] == c[i % c.length]) {
                score[2]++;
            }
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if (score[0] == max) {
            list.add(1);
        }
        if (score[1] == max) {
            list.add(2);
        }
        if (score[2] == max) {
            list.add(3);
        }

        return list.stream().mapToInt(m -> m.intValue()).toArray();
    }

    public static void main(String[] args) {
        int[] answers = { 1, 2, 3, 4, 5 }; // 1
        // int[] answers = {1,3,2,4,2}; // 1,2,3

        모의고사 s = new 모의고사();
        System.out.println(s.solution(answers));

    }
}
