public class 타겟_넘버 {
  private int answer = 0;
  public int solution(int[] numbers, int target) {
    dfs(numbers, target, 0, 0);
    return answer;
  }

  public void dfs(int[] numbers, int target, int n, int value) {
    if(n == numbers.length) {
      if(value == target) {
        answer++;
      }
      return;
    }
    dfs(numbers, target, n + 1, value+numbers[n]);
    dfs(numbers, target, n + 1, value-numbers[n]);

  }

  public static void main(String[] args) {
    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;
    타겟_넘버 s = new 타겟_넘버();
    System.out.println(s.solution(numbers, target));
  }
}

