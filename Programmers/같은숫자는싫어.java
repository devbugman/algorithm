import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        
        for(int num : arr) {
            if(s.isEmpty()) {
                s.push(num);
            }else {
                if(s.peek() != num) {
                    s.push(num);
                }
            }
        }
        int size = s.size();
        int[] answer = new int[size];
        for(int i = size - 1; i >= 0; i--) answer[i] = s.pop();
        return answer;
    }
}