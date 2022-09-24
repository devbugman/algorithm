import java.util.Arrays;

public class 행렬테두리회전 {
    // rows는 2 이상 100 이하인 자연수입니다.
    // columns는 2 이상 100 이하인 자연수입니다.
    // queries의 각 행은 4개의 정수 [x1, y1, x2, y2]입니다.

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows + 1][columns + 1];

        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = find(queries[i], map);
        }
        return answer;
    }

    private int find(int[] queries, int[][] map) {
        int x1 = queries[0];
        int y1 = queries[1];
        int x2 = queries[2];
        int y2 = queries[3];

        int temp = map[x1][y1]; // 8
        int min = temp;
        // 반시계방향으로 채워나가면 될듯?
        for (int i = x1; i < x2; i++) {
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }

        for (int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i + 1];
            min = Math.min(min, map[x2][i]);
        }

        for (int i = x2; i > x1; i--) {
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }

        for (int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i - 1];
            min = Math.min(min, map[x1][i]);
        }

        map[x1][y1 + 1] = temp;
        return min;
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
        // int[][] queries = { { 1, 1, 2, 2 }, { 1, 2, 2, 3 }, { 2, 1, 3, 2 }, { 2, 2,
        // 3, 3 } };
        행렬테두리회전 s = new 행렬테두리회전();
        int[] result = s.solution(rows, columns, queries);
        System.out.println(Arrays.toString(result));
    }
}
