import java.util.Stack;

class 크레인_인형뽑기_게임{
    public int solution(int[][]board, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int pos : moves){
            for(int i = 0; i < board.length; i++){
                if(board[i][pos-1] != 0){
                    int temp = board[i][pos-1];
                    board[i][pos-1] = 0;
                    if(!stack.isEmpty() && stack.peek() == temp){
                        stack.pop();
                        answer +=2;
                    }else{
                        stack.push(temp);
                    }
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        크레인_인형뽑기_게임 s = new 크레인_인형뽑기_게임();
        int result = s.solution(board, moves);
        System.out.println(result);
    }
}

