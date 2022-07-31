import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    
     static int[] arr;
     static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int n = Integer.parseInt(st.nextToken());

           if(n == 0) break;

            arr = new int[n];
            visit = new boolean[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
             
             solve(0, 0);  
             System.out.println(); 
            
        }
    }

    static void solve(int start, int n){
        if(n == 6){
            for(int i = 0; i < arr.length; i++){
                if(visit[i]){
                    System.out.print(arr[i] + " ");
                }
    
            }
            System.out.println();
            return;
        }else{
            for(int i = start; i < arr.length; i++){
                if(!visit[i]){
                    visit[i] = true;
                    solve(i, n+1);
                    visit[i] = false;
                }
            }
        }
    }
}
