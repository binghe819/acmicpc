import java.util.*;

// Top-Down방법
public class Main {
    static int[] memo = new int[100001];
    static int tmp;

    static int solution(int n){
        if(n <= 3)
            return n;
        if(memo[n] > 0)
            return memo[n];
        memo[n] = 100000;
        for(int i = 1; i*i <= n; i++){
            tmp = solution(n-i*i)+1;
            if(memo[n] > tmp)
                memo[n] = tmp;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(solution(N));
        sc.close();
    }
}