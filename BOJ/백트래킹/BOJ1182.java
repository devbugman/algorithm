import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
	static int N;
	static int M;
	static int[] array;
	static boolean[] visited;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0);
		System.out.println(result);
	}
	
	static void dfs(int idx, int sum, int cnt) {
		if(idx == N ) { 
			if(cnt > 0 && sum == M) { 
				result++;
			}
			return;
		}
		dfs(idx+1, sum + array[idx], cnt+1);
		dfs(idx+1, sum, cnt);
	}
}