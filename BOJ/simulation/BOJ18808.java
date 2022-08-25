import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18808 {

    static int n,m,k,cnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            int[][] sticker = new int[r][c];
            for(int x = 0; x < r; x++) {
                st = new StringTokenizer(br.readLine());
                for(int y = 0; y < c; y++) {
                    sticker[x][y] = parseInt(st.nextToken());
                }
            }

            // 회전
            for(int rot = 0; rot < 4; rot++) {
                if(attach(sticker)) { // 
                    break;
                }
                sticker = rocate(sticker); // 회전하는 메소드
            }
        }
        System.out.println(cnt);
    }

    private static int[][] rocate(int[][] sticker) {
        int r = sticker[0].length;
        int c = sticker.length;
        int[][] rocated = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                rocated[i][j] = sticker[c - j - 1][i];
            }
        }
        return rocated;
    }

    private static boolean attach(int[][] sticker) {
        for(int i = 0; i <= n - sticker.length; i++) {
            for(int j = 0; j <= m - sticker[0].length; j++) {
                if(check(sticker, i, j)){
                    attachSticker(sticker,i,j);
                    return true;
                }
            }
        }
        return false;
    }

    private static void attachSticker(int[][] sticker,int x, int y) {
        for(int i = 0; i < sticker.length; i++) {
            for(int j = 0; j < sticker[0].length; j++) {
                if(sticker[i][j] == 1) {
                    cnt++;
                    map[i + x][j + y] = sticker[i][j];
                }
            }
        }
    }

    private static boolean check(int[][] sticker, int x, int y) {
        for(int i = 0; i < sticker.length; i++) {
            for(int j = 0; j < sticker[0].length; j++) {
                if(map[x + i][y + j] == 1 && sticker[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static int parseInt(String str) {
        return Integer.parseInt(str);
    }
}
