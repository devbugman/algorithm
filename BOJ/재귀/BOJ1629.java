import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
  
    // 10^11 = 10^5 * 10^5 * 10
    // 10^5 = 10^2 * 10^2 * 10
    // 10^2 = 10^1 * 10^1

    // 제곱의 성질 이용
    // 짝수일 때는 밑^제곱수/2 * 밑^제곱수/2
    // 홀수일 때는 밑^제곱수/2 * 밑^제곱수/2 * 밑
    public long pow(long a, long b, long c){
        if(b==1) return a % c;

        long temp = pow(a, b/2, c) % c;

        // b가 짝수 일경우 
        if(b%2 == 0){
            return (temp * temp) % c;
        }else{
            //b가 홀수 일경우 
            return (((temp * temp) % c)* a) % c;
        }

    }

    public static void main(String[] args) throws IOException {
        BOJ1629 m = new BOJ1629();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        long a = Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());
        long c=Long.parseLong(st.nextToken());
        
        System.out.println(m.pow(a,b,c));
    }
}
