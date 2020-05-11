import java.util.*;

public class Main {

    static long[][] memo = new long[100002][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // bottom-up ( n이 3까지는 직접 입력해준다. )
        memo[1][1] = 1;
        memo[2][2] = 1;
        memo[3][1] = memo[3][2] = memo[3][3] = 1;
        for(int i = 4; i <= 100001; i++){
            memo[i][1] = memo[i-1][2] + memo[i-1][3];
            memo[i][2] = memo[i-2][1] + memo[i-2][3];
            memo[i][3] = memo[i-3][1] + memo[i-3][2];
            memo[i][1] %= 1000000009;
            memo[i][2] %= 1000000009;
            memo[i][3] %= 1000000009;
        }

        while(T-- > 0){
            int n = sc.nextInt();
            System.out.println((memo[n][1] + memo[n][2] + memo[n][3])%1000000009);
        }
        sc.close();
    }
}