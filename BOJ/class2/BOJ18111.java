import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {

    // N : 세로 M : 가로 집터 맨왼쪽 위는 좌표 0,0
    // 1. (i,j) 가장 위에 잇는 블록을 제거하여 인벤토리에 넣는다. 2초
    // 2. 인벤토리에서 블록 하나를 꺼내어 좌표 i,j의 가장 위에 있는 블록 위에 놓는다 1초

    // ‘땅 고르기’ 작업에 걸리는 "최소 시간"과 그 경우 땅의 "높이" 출력

    static int N, M, B;
    static int[][] map;
    static int height = 0;
    static int minTime = 0x7fffffff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int min = 0x7fffffff;
        int max = 0x80000000;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(val, max);
                min = Math.min(val, min);
            }
        }
        bruteForce(max, min);
        // 땅을 팠을때 비용과 땅을 쌓을 때 비용에서 최소 시간 날짜
        System.out.println(minTime + " " + height);
    }

    // 맵 탐색한다. 전부 같은 색인지 아닌지
    private static void bruteForce(int max, int min) {

        for (int i = min; i <= max; i++) {
            int time = 0;
            int inventory = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int val = map[j][k];
                    if (val == i)
                        continue;
                    if (val > i) {
                        time += (val - i) * 2;
                        inventory += val - i;
                    } else {
                        time += i - val;
                        inventory -= i - val;
                    }
                }
            }
            // System.out.println("i = " + i + "time" + time);
            // System.out.println("i = " + i + "inventory" +inventory);
            if(0 > inventory){
                time = 1000000000;
            }

            if(time<minTime){
                minTime = time;
                height = i;
            }else if(time == minTime &&i > height){
                height = i;
                minTime = time;
            }
        }
    }
}
