import java.util.Arrays;

class Mains {
    public int solution(int[] numbers) {
       
        return 45 - Arrays.stream(numbers).sum();
    }
}


public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        Mains s = new Mains();
        
        int[] arr = {1,2,3,4,6,7,8,0};

        System.out.println(s.solution(arr));
    }
}
