import java.util.ArrayList;
import java.util.Collections;

public class 실패율 {

    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N + 2]; // 1

        for (int i = 0; i < stages.length; i++) {
            stageCount[stages[i]]++;

        }
        int[] total = new int[N + 1];
        total[N] = stageCount[N] + stageCount[N + 1];
        for (int i = N - 1; i > 0; i--) {
            total[i] = stageCount[i] + total[i + 1];
        }

        ArrayList<Rate> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (stageCount[i] == 0) {
                list.add(new Rate(i, 0));
            }else{
                list.add(new Rate(i, (double)stageCount[i] / total[i]));
            } 
            
        }
        int[] answer = new int[N];
        Collections.sort(list, (a, b) -> Double.compare(b.rating, a.rating));

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).idx;
        }
        return answer;
               
    }

    class Rate {
        int idx;
        double rating;

        Rate(int idx, double rating) {
            this.idx = idx;
            this.rating = rating;
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
        // 3,4,2,1,5
        // int N = 4;
        // int[] stages = {4,4,4,4,4};
        // 4,1,2,3
        실패율 s = new 실패율();
        int[] result = s.solution(N, stages);
        for (int i : result) {
            System.out.print(i + ", ");
        }
    }
}
