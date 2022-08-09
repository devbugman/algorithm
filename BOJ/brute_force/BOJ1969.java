import java.io.*;
import java.util.StringTokenizer;

public class BOJ1969{

    static String[] map;
    static int hammingDistance = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        map = new String[n];
        for(int i = 0; i < n; i++){
            map[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            //Adenine, Thymine, Guanine, Cytosine
            int[] cnt = new int[4];
            for(int j = 0; j < n; j++){
                char c = map[j].charAt(i);
                switch(c){
                    case 'A' : cnt[0]++; break;
                    case 'T' : cnt[1]++; break;
                    case 'G' : cnt[2]++; break;
                    case 'C' : cnt[3]++; break;
                }
            }
            int max = Math.max(cnt[0]<cnt[1] ? cnt[1] : cnt[0], cnt[2] < cnt[3]? cnt[3] : cnt[2]);
            hammingDistance += (n - max);
            sb.append(getHammingDistance(cnt, max));
        }
        System.out.println(sb);
        System.out.println(hammingDistance);
    }

    private static char getHammingDistance(int[] cnt, int max){
        if(cnt[0] == max) return 'A';
        else if(cnt[1] == max) return 'T';
        else if(cnt[2] == max) return 'G';
        else return 'C';
    }
}