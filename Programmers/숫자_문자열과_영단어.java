
public class 숫자_문자열과_영단어 {
    public int solution(String s) {

        String[] num = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        for (int i = 0; i < num.length; i++) {
            s = s.replace(num[i], Integer.toString(i));

        }
        int answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        숫자_문자열과_영단어 s = new 숫자_문자열과_영단어();
        String str = "one4seveneight";
        s.solution(str);
    }
}
