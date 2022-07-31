import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    
    static int n;
    static int[][] arr; 
    static int[] cnt = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
      

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solve(0, 0, n);

        for(int i = 0; i < 3; i++){
            System.out.println(cnt[i]);
        }
    }

    static void solve(int row, int col, int n){
        if(isCheck(row, col, n)){
            cnt[arr[row][col] + 1] ++;
        }else{
            int size = n / 3;

            for(int  i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    solve(row + i * size, col + j * size, size);
                }
            }
        }
    }

    static boolean isCheck(int x, int y, int size){
        int color = arr[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(color != arr[i][j]){
                    return false;
                }
            }
        }

        return true;
    }

}
