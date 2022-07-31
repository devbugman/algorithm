import java.util.Scanner;

public class 문자열 {
    public int solution(String str, char c){
        int answer = 0;

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        int max = Integer.MIN_VALUE;

        for(char t : str.toCharArray()){
            if(t == c) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        문자열 main = new 문자열();
        String str = sc.nextLine();
        char c = sc.nextLine().charAt(0);

        System.out.println(main.solution(str, c));
        
    }
}
