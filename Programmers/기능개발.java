import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    

    static class Solution{
        public int[] solution(int[] progresses, int[] speeds) {
            
            List<Integer> list = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < progresses.length; i++){
                double days = (100 - progresses[i]) / (double) speeds[i];   
                int cel = (int) Math.ceil(days); 
                if(!queue.isEmpty() && queue.peek() < cel){
                    list.add(queue.size());
                    queue.clear();
                }
                queue.offer(cel);
                if(i == progresses.length - 1){
                    list.add(queue.size());
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        기능개발.Solution s = new 기능개발.Solution();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        
        int[] result = s.solution(progresses, speeds);

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
