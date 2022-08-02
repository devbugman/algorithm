import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    
    static boolean[] visit = new boolean[200002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        if(n == target) System.out.println("0");
        else bfs(n, target);

    }

    static void bfs(int n, int target){
        int[] num = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        num[n] = 1;

        while(!q.isEmpty()){
            int t = q.poll();
            for(int i = 0; i < 3; i++){
                int next;
                if(i == 0){
                    next = t - 1;
                }else if(i == 1){
                    next = t + 1;
                }else{
                    next = t * 2;
                }

                if(next == target){
                    System.out.println(num[t]);
                    return;
                }
                if(next < 0) continue;
                if(next < num.length && num[next] == 0){
                    q.offer(next);
                    num[next] = num[t] + 1;
                }

                
            }

        }

    }
}
