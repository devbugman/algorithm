import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 뉴스_클러스터링 {

    private final static int MUL = 65536;

    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // FR RA AN NC CE
        // FR RE EN NC CH
        // 1000 * 1000
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        int str1Size = str1.length();
        int str2Size = str2.length();

        for (int i = 0; i < str1Size - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            // 문자열만 두글자 씩
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                str1List.add(fromString(c1, c2));
            }
        }

        for (int i = 0; i < str2Size - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            // 문자열만 두글자 씩
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                str2List.add(fromString(c1, c2));
            }
        }

        Collections.sort(str1List);
        Collections.sort(str2List);

        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        for (String str : str1List) {
            if (str2List.remove(str)) {
                intersection.add(str);
            }
            union.add(str);
        }
        for (String str : str2List) {
            union.add(str);
        }

        if (union.size() == 0) {
            return MUL;
        }

        double d = (double) intersection.size() / (double) union.size();
        return (int) (d * MUL);
    }

    private String fromString(char c1, char c2) {
        return Character.toString(c1) + Character.toString(c2);
    }

    public static void main(String[] args) {
        String str1 = "handshake";
        String str2 = "shake hands";
        뉴스_클러스터링 s = new 뉴스_클러스터링();
        int result = s.solution(str1, str2);
        System.out.println(result);
    }
}
