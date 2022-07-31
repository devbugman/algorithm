import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class BOJ1992 {
// 8
// 11110000
// 11110000
// 00011100
// 00011100
// 11110000
// 11110000
// 11110011
// 11110011

    static int N;
    static int[][] map;
//    static boolean check;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        solve(0, 0, N);
        System.out.println(sb);

    }

    static void solve(int x, int y, int size){
        if(isCheck(x, y, size)){
            sb.append(map[x][y]);
            return;
        }else{
            sb.append("(");
            solve(x, y, size/2); // 1
            solve(x, y + size / 2, size / 2); // 오른쪽위 2
            solve(x + size / 2, y , size / 2);  // 왼쪽 아래 3
            solve(x + size / 2, y + size / 2, size / 2); // 오른쪽 아래 4
            sb.append(")");
        }
    }

    static boolean isCheck(int x, int y, int z){
        
        int image = map[x][y];

        for(int i = x; i < x + z; i++){
            for(int j = y; j < y + z; j++){
                if(image != map[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}
