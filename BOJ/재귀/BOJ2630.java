import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    
    static int N;
    static int[][] map;
    static int[] cnt = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);

        for(int z : cnt){
            System.out.println(z);
        }
    }

    static void solve(int x, int y, int size){
        if(isCheck(x, y, size)){
            cnt[map[x][y]] += 1;
            return;
        }else{
            solve(x, y, size/2);   // 1
            solve(x, y + size/2, size / 2); // 2
            solve(x + size / 2, y, size / 2); // 3
            solve(x + size / 2, y + size / 2, size / 2); //  4
        }
    }


    static boolean isCheck(int x, int y, int size){
        int val = map[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(val != map[i][j]) return false;
            }
        }

        return true;
    }
}
