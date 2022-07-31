public class 약수의_개수와_덧셈 {

    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++){
            int max = 0;
            int count = 0;
            for(int j = 1; j <= i; j++){
                if(i % j == 0){
                    count++;
                }
                if(j > max)max = j; 
            }
            if(count % 2 != 0)answer -= max;
            else answer +=max;
        }

        return answer;
    }
    public static void main(String[] args) {
        
        약수의_개수와_덧셈 s = new 약수의_개수와_덧셈();
        System.out.println(s.solution(13, 17));;
    }
}
