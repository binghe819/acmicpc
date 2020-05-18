import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] memo = new int[K+1][N+1];

        memo[0][0] = 1;
        for(int k = 1 ; k <= K; k++){
            for(int n = 0; n <= N; n++){
                for(int i = 0; i <= n; i++){
                    memo[k][n] += memo[k-1][i];
                    memo[k][n] %=1000000000;
                }
            }
        }

        System.out.println(memo[K][N]);

        sc.close();
    }
}