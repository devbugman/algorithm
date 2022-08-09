import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
    
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            if(value > last){
                for(int j = last + 1; j <= value; j++){
                    sb.append("+").append("\n");
                    stack.push(j);
                }
                last = value;
            }else if(stack.peek()!= value){
                System.out.println("NO");
                return;
            }
            sb.append("-").append("\n");
            stack.pop();
        }
        System.out.println(sb);
    }
}

// start = 0; 
// value 4;
// value > start 
// for i = start+ 1 i < value;
// 	appand("+") // push = "+"; // ++++
// 	push 1 2 3 4
// start = value;   // start = 4; 

// else if (stack != value)

// stack.pop();  //  3
// sb.appand("-") // pop = "-"; //++++-


// stack = 123
// start = 4;
// value = 3;

// pop() // 3 "-"//++++--

// stack 12

// start = 4;
// value = 6;
// for( satrt value ; 
// 	1 2 5 6 push //++++--++

// start = 6
// stack pop  6//++++--++-

// start = 6 
// value 8
// for start value
// 	1 2 5 7push 7 8 //++++--++-++
// pop() 8 //++++--++-++-

// start = 8;

// 1 2 5
