import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1978 {
    
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        
        Arrays.stream(numbers)
            .mapToInt(Integer::parseInt)
            .forEach((value) -> {
                boolean isPrime = true;
                if(value == 1) return;
                for(int i = 2; i <= Math.sqrt(value); i++){
                    if(value % i == 0){
                        isPrime = false; 
                        break;
                    }
                }
                if(isPrime){
                    count++;
                }
            });  
        
        System.out.println(count);
    }

}
