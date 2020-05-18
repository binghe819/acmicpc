import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] memo = new long[N+1];

        memo[1] = 1;

        for(int i = 2; i <= N; i++){
            if(i == 2){
                memo[i] = 1;
                continue;
            }
            memo[i] = memo[i-1] + memo[i-2];
        }

        long result = memo[N];
        System.out.println(result);

        sc.close();
    }
}