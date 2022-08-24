import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {
    
    private static int N;
    private static int max = Integer.MIN_VALUE;
    private static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        eggs = new Egg[N]; 
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int attack = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(hp, attack);
        }

        backTracking(0);
        System.out.println(max);
    }

    private static void backTracking(int curr) {
        if(curr == N) { // 종료 조건
            int count = 0; // 계란이 깨진갯수
            for(int i = 0; i < N; i++) {
                if(eggs[i].hp <= 0) count++;
            }
            // 계란을 깰 수 있는 최대갯수
            max = Math.max(max, count);
            return;
        }
        // 현재 든 계란의 내구도가 0 이하이거나 모든 계란이 다 깨졌을경우 .
        if(eggs[curr].hp <= 0){
            backTracking(curr + 1);
            return;
        }
        // 
        for(int i = 0; i < N; i++) {
            if(i == curr) continue;
            if(eggs[i].hp <= 0) continue;
            // 현재 손에 든 계란의 hp
            // 오른손에 든 계란
            int left = eggs[curr].hp;
            int right = eggs[i].hp;
            
            // 서로 공격하여 내구도 까기
            eggs[curr].hp -= eggs[i].attack;
            eggs[i].hp -= eggs[curr].attack;
            backTracking(curr + 1);
            eggs[curr].hp = left;
            eggs[i].hp = right;
        }
        if(curr == N - 1) backTracking(curr + 1);
    }

    private static class Egg {
        int hp;
        int attack;

        Egg(int hp, int attack) {
            this.hp = hp;
            this.attack = attack;
        }

    }
}
