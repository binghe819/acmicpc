import java.util.*;

// Top-Down 방식
public class Main {

    static long[] memo;

    static long solution(int n){
        if(n <= 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 4;

        if(memo[n] > 0)
            return memo[n];

        memo[n] = solution(n-1)+solution(n-2)+solution(n-3);
        memo[n] %= 1000000009;
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        memo = new long[10000];

        while(T-- > 0){
            int n = sc.nextInt();
            System.out.println(solution(n));
        }
        sc.close();
    }
}