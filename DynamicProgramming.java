import javax.lang.model.element.QualifiedNameable;

public class DynamicProgramming {
    /**
     * 동적 계획법 - DP
     * 
     * 입력 크기가 작은 부분들을 해결 한 후, 해당 부분 문제의 해를 활용해서
     * 보다 큰 크기의 부분 문제를 해결, 최종적으로 전체 문제를 해결하는 알고리즘
     * 
     * Memoization 기법을 사용한다.
     * 상향식 접근법
     * 
     * 프로그램 실행시 이전에 계산한 값을 지정하며, 다시 계산하지 않도록
     * 전체 실행 속도를 빠르게 하는 기술
     * 
     * 분할 정복
     * 하향식 접근법
     * 일반적으로 재귀함수로 구현
     *  Memoization 기법을 사용하지 않는다
     * 
     *  ex) 병합 정렬, 퀵 정렬 (merge sort, quick sort)
     * 
     */
     
     public static void main(String[] args) {
     // Dp fibonacci()
        System.out.println(fibonacci(11));
        System.out.println(fibo(11));
     }

     private static int[] arr = new int[10001];
     // 재귀 형태
     private static int fibonacci(int n){
        if(arr[n] != 0) return arr[n];
        if(n == 1 || n == 2) return 1;
        return arr[n] = fibonacci(n - 1) + fibonacci(n - 2);
     }

     // 반복문 형태
     private static int fibo(int n){
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i <= n; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
     }

     // 퀵소트
     private static void quickSort(int[] arr, int left, int right){
        int i, j, pivot, tmp;
        if(left < right){
            i = left; j = right;
            pivot= arr[(left+right) / 2];
            while(i < j){
                while(arr[j] > pivot)
                    j--;
                while(arr[i] < pivot)
                    i++;
                if(i < j){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }
            }
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}
