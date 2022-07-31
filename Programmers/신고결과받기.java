import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //중복제거 
        Set<String> reportSet = new HashSet<>();
        for(String str : report){
            reportSet.add(str);
        }

        //신고 당한사람 hash
        HashMap<String,List<String>> reports = new HashMap<>();
        for(String str : id_list){
            reports.put(str, new ArrayList<>());
        }
        
        for(String str : reportSet){
            StringTokenizer st = new StringTokenizer(str);
            String reportId = st.nextToken(); // 신고한사람
            String reportedId = st.nextToken();  // 신고당한
            reports.get(reportedId).add(reportId);
        }

        //메일 보낼 아이디와 카운트
        HashMap<String,Integer> result = new HashMap<>();

        for(String person : reports.keySet()){
            if(reports.get(person).size() >= k){
                
                for(String resPerson : reports.get(person)){ // 신고한사람 메일 추가 
                    result.put(resPerson, result.getOrDefault(resPerson, 0) + 1);
                    
                }
            }
        }

        for(int i = 0; i<id_list.length; i++){
            answer[i] = result.getOrDefault(id_list[i], 0);
           
        }

        return answer;
    }
    public static void main(String[] args) {
        // String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        // String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        // int k = 2;
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        
        신고결과받기 s = new 신고결과받기();
        int[] result = s.solution(id_list, report, k);
        System.out.println(result);
    }
}

