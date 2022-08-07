import java.util.*;
public class 오픈채팅방 {
    
    public String[] solution(String[] record) {
        Map<String,String>userMap = new HashMap<>();
        for(String user : record){
            String[] str = user.split(" ");
            if(str.length > 2){
                userMap.put(str[1], str[2]);
            }
        }

        List<String> list = new ArrayList<>();
        for(String str : record){
            String[] users = str.split(" ");
            String user = userMap.get(users[1]);
            if("Enter".equals(users[0])){
                list.add(user + "님이 들어왔습니다.");
            }else if("Leave".equals(users[0])){
                list.add(user + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        오픈채팅방 s = new 오픈채팅방();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = s.solution(record);
        for(String r : result){
            System.out.println(r);
        }
    }
}


