import java.util.ArrayList;

public class Test {
    
    public ArrayList<String> solution(String[] str){
        ArrayList<String> list = new ArrayList<>();
        for(String st : str){
            char[] c = st.toCharArray();

            int start = 0,end = c.length - 1;

            while(start < end){
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;

                start++;
                end--;
            }
            String s = String.valueOf(c);
            list.add(s);
        }

        return list;
    }
    /**
     * 문자열 뒤집기 
     * @author chanbokW
     */
    public static void main(String[] args) {
        Test t = new Test();
        String[] str = {"goods", "study","english"};
        for(String st : t.solution(str))
            System.out.println(st);

    }
}
