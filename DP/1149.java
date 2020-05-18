import java.util.*;

public class Main {

    public static int min(int a, int b){
        return a > b ? b : a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] A = new int[N+1][3];
        int[][] memo = new int[N+1][3];

        for(int i = 1; i <= N; i++){
            for(int j = 0; j < 3; j++)
                A[i][j] = sc.nextInt();
        }

        // N번집까지 최소 비용으로 색칠. DP 이용.
        for(int i = 1; i <= N; i++){
            memo[i][0] = min(memo[i-1][1], memo[i-1][2]) + A[i][0];
            memo[i][1] = min(memo[i-1][0], memo[i-1][2]) + A[i][1];
            memo[i][2] = min(memo[i-1][0], memo[i-1][1]) + A[i][2];
        }

        // 최소값 출력.
        System.out.println((memo[N][0] > memo[N][1] ? memo[N][1] : memo[N][0]) > memo[N][2] ? memo[N][2] : (memo[N][0] > memo[N][1] ? memo[N][1] : memo[N][0]) );

        sc.close();
    }
}