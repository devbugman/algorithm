public class Star {
    public final static int MAX = 1024 * 3 + 2;
    static int n;
    static char[][]board = new char[MAX][MAX*2-1];

    static void board(int x, int y){
        board[x][y] = '*';
        board[x+1][y-1] = '*';
        board[x+1][y+1] = '*';

        for(int i = y; i<=y + 2; ++i){
            board[x+2][i] = '*';
        }
    }

    static void func(int s, int x, int y){
        if(s==3){
            board(x,y);
            return;
        }

        int ns = s/2;
        func(ns, x, y);
        func(ns, x+ns, y-ns);
        func(ns, x+ns, y+ns);
    }


    public static void main(String[] args) {
        n = 24;
        func(n, 0, n-1);
        for(int i =0; i < n; ++i){
            for(int j = 0; j<n*2-1; ++j){
                if(board[i][j] == '*')
                    System.out.print('*');
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
