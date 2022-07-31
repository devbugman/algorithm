public class 다트게임 {
    
    public int solution(String dartResult) {
        //s1 d2 t3
        // * x2   # -
        // * 첫번째 x2
        // *  다른 스타상* 중복효과와 중첩 이경우 * x4
        //  * # 중첩 중첩된 # -2배 
        // s d t 는 점수마다 하나씩 존재
        // * # 둘중하나 존재하거나 존재하지 않을 수 있다.
        // 1~10정수
        // 턴은 3번 
        int turn = 0;
        int[] score = new int[3];
        for(int i = 0; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);

            if(Character.isDigit(c)){
                if(c == '1' && dartResult.charAt(i + 1) == '0'){
                    score[turn] = 10;
                }else{
                    score[turn] = c + '0';
                }
            }else{
                if(c == 'T' || c == 'D' || c == 'S'){
                    score[turn] = pow(score[turn], c);
                }
            }
        }

        int answer = 0;
        return answer;
    }

    private int pow(int n, char t){
        int result = 0;
        if(t=='D'){
            result = (int)Math.pow(n, 2);
        }else if(t=='T'){
            result = (int)Math.pow(n, 3);
        }else{
            result = n;
        }
        return result;
    }

    public static void main(String[] args) {
        다트게임 s = new 다트게임();

        // String dartResult = "1S2D*3T"; //37
        // String dartResult = "1D2S#10S"; // 9
        String dartResult = "1D2S0T"; // 3
        // String dartResult = "1S*2T*3S"; // 23
        System.out.println(s.solution(dartResult));
    }
}
