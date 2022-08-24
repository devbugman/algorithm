import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15683 {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visit;
    private static int zeroCount = 0;
    private static List<Cctv> cctvs;
    private static int[] dir;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        answer = Integer.MAX_VALUE;
        cctvs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroCount++;
                }
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctvs.add(new Cctv(i, j, map[i][j]));
                }
            }
        }
        // 0 은 빈칸 6은 벽 1 ~ 5 cctv 번호 경우의 수 구하기
        // 1 상 하 좌 우 4가지
        // 2 상하 좌우 2가지
        // 3 좌상 우상 좌하 우하 4가지
        // 4 좌상우 우상하 좌상하 우하좌 4가지
        // 5 상하좌우 1가지
        // 21845 * 8
        dir = new int[] { 0, 4, 2, 4, 4, 1 };
        buildCctv(new int[cctvs.size()], 0);
        System.out.println(answer);
    }

    private static void buildCctv(int[] cases, int idx) {
        // cctv 번호로 1 ,2 ,3, 4, 5
        if (idx == cctvs.size()) {
            findCctv(cases);
            return;
        }
        // 방향
        for (int i = 1; i <= dir[cctvs.get(idx).value]; i++) {
            // cases = [1, 1, 1, 1, 1] [2, 3, 4, 1, 4]
            cases[idx] = i;
            buildCctv(cases, idx + 1);
        }
    }

    private static void findCctv(int[] cases) {
        int deleteCount = zeroCount;
        visit = new boolean[n][m];
        for (int i = 0; i < cctvs.size(); i++) {
            Cctv cctv = cctvs.get(i);
            switch (cctv.value) {
                case 1:
                    deleteCount -= findCctvOne(cctv.x, cctv.y, cases[i]);
                    break;
                case 2:
                    deleteCount -= findCctvTwo(cctv.x, cctv.y, cases[i]);
                    break;
                case 3:
                    deleteCount -= findCctvThree(cctv.x, cctv.y, cases[i]);
                    break;
                case 4:
                    deleteCount -= findCctvFour(cctv.x, cctv.y, cases[i]);
                    break;
                case 5:
                    deleteCount -= findCctvFive(cctv.x, cctv.y);
                    break;
            }
        }
        answer = Math.min(answer, deleteCount);
    }

    // cctv 윗방향
    private static int up(int x, int y) {
        int count = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] == 6) {
                break;
            } 
            if (map[i][y] == 0 && !visit[i][y]) {
                visit[i][y] = true;
                count++;
            }
        }
        return count;
    }

    // cctv 아래방향
    private static int down(int x, int y) {
        int count = 0;
        for (int i = x + 1; i < n; i++) {
            if (map[i][y] == 6) {
                break;
            }
            if (map[i][y] == 0 && !visit[i][y]) {
                visit[i][y] = true;
                count++;
            }
        }
        return count;
    }

    // 왼쪽방향
    private static int left(int x, int y) {
        int count = 0;
        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] == 6) {
                break;
            }
            if (map[x][i] == 0 && !visit[x][i]) {
                count++;
                visit[x][i] = true;
            }
        }
        return count;
    }

    // 오른쪽 방향
    private static int right(int x, int y) {
        int count = 0;
        for (int i = y + 1; i < m; i++) {
            if (map[x][i] == 6) {
                break;
            } else if (map[x][i] == 0 && !visit[x][i]) {
                count++;
                visit[x][i] = true;
            }
        }
        return count;
    }

    private static int findCctvOne(int x, int y, int idx) {
        int count = 0;
        switch (idx) {
            case 1:// 상
                count += up(x, y);
                break;
            case 2: // 하
                count += down(x, y);
                break;
            case 3: // 좌
                count += left(x, y);
                break;
            case 4:
                count += right(x, y);
                break;
        }
        return count;
    }

    private static int findCctvTwo(int x, int y, int idx) {
        int count = 0;
        switch (idx) {
            case 1:
                // 상 하
                count += up(x, y) + down(x, y);
                break;
            case 2: // 좌 우
                count += left(x, y) + right(x, y);
                break;
        }
        return count;
    }

    private static int findCctvThree(int x, int y, int idx) {
        int count = 0;
        switch (idx) {
            case 1:// 상 좌
                count += up(x, y) + left(x, y);
                break;
            case 2: // 상 우
                count += up(x, y) + right(x, y);
                break;
            case 3: // 하 우
                count += down(x, y) + right(x, y);
                break;
            case 4: // 하 좌
                count += down(x, y) + left(x, y);
                break;
        }
        return count;
    }

    private static int findCctvFour(int x, int y, int idx) {
        int count = 0;
        switch (idx) {
            case 1:// 상 좌 우
                count += up(x, y) + left(x, y) + right(x, y);
                break;
            case 2: // 하 좌 우
                count += down(x, y) + right(x, y) + left(x, y);
                break;
            case 3: // 좌 상 하
                count += left(x, y) + right(x, y) + up(x, y);
                break;
            case 4: // 우 상 하
                count += right(x, y) + up(x, y) + down(x, y);
                break;
        }
        return count;
    }

    private static int findCctvFive(int x, int y) {
        // 상 하 좌 우 4방향
        int count = 0;
        count += up(x, y) + down(x, y) + left(x, y) + right(x, y);
        return count;
    }

    // private static boolean existSix(int x, int y) {
    //     return map[x][y] == 6;
    // }

    // // zero이면서 방문하지 않았다면
    // private static boolean existZero(int x, int y) {
    //     return map[x][y] == 0 && !visit[x][y];
    // }

    private static class Cctv {
        int x; // cctv x좌표
        int y; // cctv y좌표
        int value; // cctv번호

        Cctv(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}