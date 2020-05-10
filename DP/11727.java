import java.util.*;

public class Main {

    static int[] memo = new int[1001];

    static int tile(int n){
        if(n == 1)
            return n;
        if(n == 2)
            return n+1;
        if(memo[n] > 0)
            return memo[n];
        memo[n] = (tile(n-1) + 2*tile(n-2))%10007;
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(tile(n));
        sc.close();
    }
}