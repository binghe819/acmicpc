import java.util.*;

public class Main {

    static long[][] memo = new long[91][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        memo[1][0] = 0;
        memo[1][1] = 1;
        for(int i = 2; i<=N; i++){
            memo[i][0] = memo[i-1][0] + memo[i-1][1];
            memo[i][1] = memo[i-1][0];
        }
        System.out.println(memo[N][0] + memo[N][1]);
        sc.close();
    }
}