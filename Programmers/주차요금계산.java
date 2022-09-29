import java.util.*;

public class 주차요금계산 {

    private static final String IN = "IN";
    private static final String OUT = "OUT";

    public int[] solution(int[] fees, String[] records) {

        HashMap<String, Integer> park = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        // 기본 시간(분) / 기본 요금 / 단위시간 /단위요금
        // 주차요금 계산 기본요금 +[누적 주차시간 - 기본시간 / 10] * 단위요금
        // 기본시간 초과 x = 기본요금

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            int time = convert(st.nextToken());
            String carNumber = st.nextToken();
            String status = st.nextToken();
            if (IN.equals(status)) {
                park.put(carNumber, time);
                if (!result.containsKey(carNumber)) {
                    result.put(carNumber, 0);
                }
            } else {
                int parkTime = time - park.get(carNumber);
                result.put(carNumber,
                        result.get(carNumber) + parkTime);
                park.remove(carNumber);
            }
        }

        if (!park.isEmpty()) {
            for (String key : park.keySet()) {
                int time = convert("23:59") - park.get(key);
                result.put(key, result.get(key) + time);
            }
        }

        List<String> parks = new ArrayList<>(result.keySet());
        Collections.sort(parks);
        int idx = 0;
        int[] answer = new int[parks.size()];
        for (String key : parks) {
            int x = result.get(key);
            if (x < fees[0])
                answer[idx++] = fees[1];
            else {
                int fee = fees[1] + (int) Math.ceil((double) (x - fees[0]) / fees[2]) * fees[3];
                answer[idx++] = fee;
            }
        }
        return answer;
    }

    public int convert(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        int time = parseInt(st.nextToken());
        int sec = parseInt(st.nextToken());
        return time * 60 + sec;
    }

    private int parseInt(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        주차요금계산 s = new 주차요금계산();

        int[] fees = { 180, 5000, 10, 600 };
        String[] record = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

        int[] reselt = s.solution(fees, record);
        System.out.println(Arrays.toString(reselt));
    }

}
