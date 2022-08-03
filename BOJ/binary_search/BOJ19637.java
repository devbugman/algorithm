import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ19637 {
    
    static int n,m;
    static List<Type> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Type(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(br.readLine());
            String res = binarySearch(num);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static String binarySearch(int num){
        int start = 0, end = list.size() - 1, mid =  0;
        while(start <= end){
            mid = (start + end) / 2;
            if(num > list.get(mid).number) start = mid + 1;
            else end = mid - 1;
        }
        return list.get(end + 1).name;
    }

    static class Type{
        String name; 
        int number;
        Type(String name, int number){
            this.name = name;
            this.number = number;
        }
    }
}
