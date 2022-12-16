import java.util.Stack;

public class 괄호_회전_하기 {

    public int solution(String s) {
        int answer = 0;
        char[] charArr = s.toCharArray();
        char[] temp = charArr;
        for (int i = 0; i < charArr.length; i++) {
            if (isStackEmpty(temp)) {
                answer++;
            }
            temp = copyArr(temp);
        }
        return answer;
    }

    private char[] copyArr(char[] tempArr) {
        int size = tempArr.length;
        char[] temp = new char[size];
        char value = tempArr[0];
        for (int i = 0; i < size - 1; i++) {
            temp[i] = tempArr[i + 1];
        }
        temp[size - 1] = value;
        return temp;
    }

    private boolean isStackEmpty(char[] arr) {
        Stack<Character> s = new Stack<>();
        for (char value : arr) {
            switch (value) {
                case '[':
                case '{':
                case '(':
                    s.push(value);
                    break;
                case ']':
                    if (s.isEmpty())
                        return false;
                    if (!isValid(s.peek(), '['))
                        return false;
                    s.pop();
                    break;
                case '}':
                    if (s.isEmpty())
                        return false;
                    if (!isValid(s.peek(), '{'))
                        return false;
                    s.pop();
                    break;
                case ')':
                    if (s.isEmpty())
                        return false;
                    if (!isValid(s.peek(), '('))
                        return false;
                    s.pop();
                    break;
            }
        }
        return s.isEmpty();
    }

    private boolean isValid(char c1, char c2) {
        return c1 == c2;
    }

    public static void main(String[] args) {
        괄호_회전_하기 s = new 괄호_회전_하기();
        String str = "}]()[{";
        int result = s.solution(str);
        System.out.println(result);
    }
}