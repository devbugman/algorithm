import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<') {
                print(s);
                flag = true;
                System.out.print(c);
            } else if (c == '>') {
                flag = false;
                System.out.print(c);
            } else if (flag) {
                System.out.print(c);
            } else {
                if (c == ' ') {
                    print(s);
                    System.out.print(c);
                } else {
                    s.push(c);
                }
            }
        }
        print(s);
    }

    private static void print(Stack<Character> s){
        while(!s.isEmpty()){
            System.out.print( s.pop());
           
        }
    }
}
