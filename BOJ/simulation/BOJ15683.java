import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683 {

    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<SecurityCamera> cctvs;
    static int cctvSize;
    static int zeroCount;
    static int minCount;
    static int[] dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cctvs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroCount++;
                }
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctvs.add(new SecurityCamera(i, j, map[i][j]));
                }
            }
        }

        cctvSize = cctvs.size();
        dir = new int[] { 0, 4, 2, 4, 4, 1 };
        minCount = Integer.MAX_VALUE;
        changeDirection(new int[cctvSize], 0);
        System.out.println(minCount);

    }

    private static void changeDirection(int[] camera, int depth) {
        if (depth == cctvSize) {
            findCamera(camera);
            return;
        }
        for (int i = 1; i <= dir[cctvs.get(depth).number]; i++) {
            camera[depth] = i;
            changeDirection(camera, depth + 1);
        }
    }

    private static void findCamera(int[] camera) {
        visit = new boolean[n][m];
        int cnt = zeroCount;
        for (int i = 0; i < cctvSize; i++) {
            SecurityCamera cctv = cctvs.get(i);
            switch (cctv.number) {
                case 1:
                    cnt -= findCctvOne(cctv, camera[i]);
                    break;
                case 2:
                    cnt -= findCctvTwo(cctv, camera[i]);
                    break;
                case 3:
                    cnt -= findCctvThree(cctv, camera[i]);
                    break;
                case 4:
                    cnt -= findCctvFour(cctv, camera[i]);
                    break;
                case 5:
                    cnt -= findCctvFive(cctv);
                    break;
            }
        }
        minCount = Math.min(minCount, cnt);
    }

    private static int up(SecurityCamera cctv) {
        int cnt = 0;
        for (int i = cctv.x - 1; i >= 0; i--) {
            if (map[i][cctv.y] == 6) {
                break;
            }
            if (map[i][cctv.y] == 0 && !visit[i][cctv.y]) {
                cnt++;
                visit[i][cctv.y] = true;
            }
        }
        return cnt;
    }

    private static int down(SecurityCamera cctv) {
        int cnt = 0;
        for (int i = cctv.x + 1; i < n; i++) {
            if (map[i][cctv.y] == 6) {
                break;
            }
            if (map[i][cctv.y] == 0 && !visit[i][cctv.y]) {
                cnt++;
                visit[i][cctv.y] = true;
            }
        }
        return cnt;
    }

    private static int left(SecurityCamera cctv) {
        int cnt = 0;
        for (int i = cctv.y - 1; i >= 0; i--) {
            if (map[cctv.x][i] == 6) {
                break;
            }
            if (map[cctv.x][i] == 0 && !visit[cctv.x][i]) {
                cnt++;
                visit[cctv.x][i] = true;
            }
        }
        return cnt;
    }

    private static int right(SecurityCamera cctv) {
        int cnt = 0;
        for (int i = cctv.y + 1; i < m; i++) {
            if (map[cctv.x][i] == 6) {
                break;
            }
            if (map[cctv.x][i] == 0 && !visit[cctv.x][i]) {
                cnt++;
                visit[cctv.x][i] = true;
            }
        }
        return cnt;
    }

    private static int findCctvFive(SecurityCamera cctv) {
        int count = 0;
        count += up(cctv) + down(cctv) + left(cctv) + right(cctv);
        return count;
    }

    private static int findCctvFour(SecurityCamera cctv, int camera) {
        int count = 0;
        switch (camera) {
            case 1:// 상 좌 우
                count += up(cctv) + left(cctv) + right(cctv);
                break;
            case 2: // 우 상 하
                count += right(cctv) + up(cctv) + down(cctv);
                break;
            case 3: // 하 우 좌
                count += down(cctv) + right(cctv) + left(cctv);
                break;
            case 4: // 좌 하 상
                count += left(cctv) + down(cctv) + up(cctv);
                break;
        }
        return count;
    }

    private static int findCctvThree(SecurityCamera cctv, int camera) {
        int count = 0;
        switch (camera) {
            case 1:// 상 좌
                count += up(cctv) + left(cctv);
                break;
            case 2: // 상 우
                count += up(cctv) + right(cctv);
                break;
            case 3: // 하 우
                count += down(cctv) + right(cctv);
                break;
            case 4: // 하 좌
                count += down(cctv) + left(cctv);
                break;
        }
        return count;
    }

    private static int findCctvTwo(SecurityCamera cctv, int camera) {
        int count = 0;
        switch (camera) {
            case 1:
                // 상 하
                count += up(cctv) + down(cctv);
                break;
            case 2: // 좌 우
                count += left(cctv) + right(cctv);
                break;
        }
        return count;
    }

    private static int findCctvOne(SecurityCamera cctv, int camera) {
        int count = 0;
        switch (camera) {
            case 1:// 상
                count += up(cctv);
                break;
            case 2: // 하
                count += down(cctv);
                break;
            case 3: // 좌
                count += left(cctv);
                break;
            case 4:
                count += right(cctv);
                break;
        }
        return count;
    }

    static class SecurityCamera {
        int x;
        int y;
        int number;

        SecurityCamera(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }
}