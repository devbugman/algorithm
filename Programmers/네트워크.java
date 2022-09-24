public class 네트워크 {
    // private int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers, visited);
            }
        }
        
        return answer;
    }
    
    private void dfs(int x, int[][] computers, boolean[] visited) {
        visited[x] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[x][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }

    public static void main(String[] args) {
        int result = new 네트워크().solution(3, new int[][]{{1, 1, 0},{1, 1, 0},{0, 0, 1}});
        System.out.println(result);
    }
}
