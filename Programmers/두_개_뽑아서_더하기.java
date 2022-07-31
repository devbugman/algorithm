import java.util.*;
public class 두_개_뽑아서_더하기 {
    
    public int[] solution(int[] numbers) {
        Set<Integer>set = new HashSet<>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j< numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(i -> i.intValue()).toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};
        두_개_뽑아서_더하기 s = new 두_개_뽑아서_더하기();
        int[]result = s.solution(numbers);
        
        for(int i : result){
            System.out.println(i);
        }
    }
}
