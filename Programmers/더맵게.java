import java.util.*;
public class 더맵게 {
    
    public int solution(int[] scoville, int k){
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int scale : scoville){
            heap.offer(scale);
        }

        while(heap.peek() <= k){
            if(heap.size() <= 1){
                return -1;
            }

            int a = heap.poll();
            int b = heap.poll();

            //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            int reuslt = a + b * 2;
            heap.offer(reuslt);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        더맵게 s = new 더맵게();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(s.solution(scoville, k));
    }
}
