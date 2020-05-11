import java.util.*;

public class Main {

    static long[][] memo = new long[101][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 1; i <= 9; i++){
            memo[1][i] = 1;
        }
        // i는 자리수 , j는 마지막 수.
        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                if(j-1 >= 0) // 마지막 수가 0보다 큰 경우 ( j가 0이면 넘어간다. )
                    memo[i][j] += memo[i-1][j-1];
                if(j+1 <= 9) // 마지막 수가 9보다 작은 경우 ( j가 9이면 넘어간다. )
                    memo[i][j] += memo[i-1][j+1];
                memo[i][j] %= 1000000000;
            }
//            memo[i][0] = memo[i-1][1];†
//            memo[i][1] = (memo[i-1][0] + memo[i-1][2])%1000000000;
//            memo[i][2] = (memo[i-1][1] + memo[i-1][3])%1000000000;
//            memo[i][3] = (memo[i-1][2] + memo[i-1][4])%1000000000;
//            memo[i][4] = (memo[i-1][3] + memo[i-1][5])%1000000000;
//            memo[i][5] = (memo[i-1][4] + memo[i-1][6])%1000000000;
//            memo[i][6] = (memo[i-1][5] + memo[i-1][7])%1000000000;
//            memo[i][7] = (memo[i-1][6] + memo[i-1][8])%1000000000;
//            memo[i][8] = (memo[i-1][7] + memo[i-1][9])%1000000000;
//            memo[i][9] = (memo[i-1][8])%1000000000;
        }

        long result = 0;
        for(int i = 0; i <= 9; i++)
            result+=memo[N][i];
        System.out.println(result%1000000000);
        sc.close();
    }
}