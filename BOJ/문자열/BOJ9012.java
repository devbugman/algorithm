
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			Stack<Character> s = new Stack<Character>();
			String str = br.readLine();
			boolean flag = true;
			for(int j = 0; j<str.length(); j++) {
				char c = str.charAt(j);
				
				if(c == '(') {
					s.push(c);
				}else if(s.empty()) {
					flag = false;
					break;
				}else {
					s.pop();
				}
				
			}
			
			if(s.empty() && flag) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb);
	}

}
