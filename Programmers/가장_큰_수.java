import java.util.*;
public class 가장_큰_수{

    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();       
        for(int i : numbers){
            list.add(Integer.toString(i));
        }
        Collections.sort(list, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        if(list.get(0).equals("0"))return "0";
        String answer = "";
        for(String str : list){
            answer += str;
        }
        return answer;    
    }
   

    public static void main(String[] args) {
        가장_큰_수 s = new 가장_큰_수();
        // int[] numbers = {6, 10, 2};  //6210
        int[] numbers = {3, 30, 34, 5, 9};  //9534330
        System.out.println(s.solution(numbers));
    }




}
