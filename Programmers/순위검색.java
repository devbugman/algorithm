import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색 {

    private HashMap<String,ArrayList<Integer>> userInfo = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for(String str : info){
            String[] array = str.split(" ");
            dfs(array, "", 0);
        }
        for(String key : userInfo.keySet()){
            Collections.sort(userInfo.get(key));
        }

        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++){
            query[i] = query[i].replaceAll(" and ", "");
            String[] array = query[i].split(" ");
            // System.out.println(array[0]);
            // System.out.println(array[1]);
            answer[i] = userInfo.containsKey(array[0]) ? binaySearch(array[0],Integer.parseInt(array[1])) : 0;
        }
        return answer;
    }

    void dfs(String[] info,String str, int depth){
        if(depth == 4){
            ArrayList<Integer> list =userInfo.getOrDefault(str, new ArrayList<>());
            list.add(Integer.parseInt(info[4]));
            userInfo.put(str, list);
            return;
        }
        dfs(info,str+"-",depth+1);
        dfs(info, str+info[depth], depth+1);
    }

    int binaySearch(String key, int value){
        ArrayList<Integer> list = userInfo.get(key);
        int right = 0, left = list.size() - 1;
        while(right <= left){
            int mid = (right + left)/ 2;
            if(list.get(mid) < value){
                right = mid + 1;
            }else{
                left = mid - 1;
            }
        }
        return list.size() - right;
    }
   

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        순위검색 s = new 순위검색();
        int[] result = s.solution(info, query);
        for(int i : result){
            System.out.println(i);
        }
    }
}
