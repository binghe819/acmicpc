import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n+1];
        int[] memo = new int[n+1];

        // 입력
        for(int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        memo[0] = A[0];
        for(int i = 1; i < n ;i++){
            if(memo[i-1] + A[i] >= A[i]){
                memo[i] = memo[i-1] + A[i];
            } else {
                memo[i] = A[i];
            }
        }

//        for (int i = 0; i < n; i++) {
//            memo[i] = A[i];
//            if (i == 0) {
//                continue;
//            }
//            if (memo[i] < memo[i-1] + A[i]) {
//                memo[i] = memo[i-1] + A[i];
//            }
//        }

        // 최대값 찾기
        int max = memo[0];
        for(int i = 1; i < n; i++){
            if(memo[i] > max)
                max = memo[i];
        }

        System.out.println(max);
        sc.close();
    }
}