public class 신규_아이디_추천 {

    public String solution(String new_id) {
            String answer = new_id.toLowerCase();
            answer = answer.replaceAll("[^-_.a-z0-9]", "")
                    .replaceAll("[.]{2,}", ".")
                    .replaceAll("^[.]|[.]$", "");

            if (answer.isEmpty())
                answer = "a";

            if (answer.length() >= 16) {
                answer = answer.substring(0, 15).replaceAll("[.]$", "");
            }
            if (answer.length() <= 2) {
                while (answer.length() < 3) {
                    answer += answer.substring(answer.length() - 1);
                }
            }
            return answer;
      
       
    }
    public static void main(String[] args) {

        String a = "2";
        System.out.println(a.isEmpty());

    }

}
