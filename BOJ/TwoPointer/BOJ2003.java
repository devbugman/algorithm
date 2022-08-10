import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    /*
     * 4 2
     * 1 1 1 1  3
     * 
     * /1 + 1 2 1 + 1 2 1 + 1 2
     * 
     * 10 5
     * 1 2 3 4 2 5 3 1 1 2 
     * 1 + 2 + 3 > 5  2 + 3 == 5  1
     * 3  < 5 3 + 4 >5  4 + 2 2 + 5  5 == 5  1 3 + 1 + 1 3   
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0; 
        int end = 0;
        int sum = a[0];
        int count = 0;

        while(end < n){
            if(sum < m){
                end++;
                if(end >= n)break; 
                sum += a[end];
            }else if(sum == m){
                count++;
                end++;
                if(end >= n) break;
                sum += a[end];
            }else{
                sum -=a[start];
                start++;
                if(start>end){
                    end = start;
                    if(start < n)sum = a[end];
                }
            }
        }
        System.out.println(count);
    }
}
