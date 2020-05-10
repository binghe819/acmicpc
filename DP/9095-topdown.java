import java.util.*;

public class Main {

    static int[] memo = new int[12];

    static int plusOneTwoThree(int n){
        if(n <= 2)
            return n;
        if(n == 3)
            return n+1;
        if(memo[n] > 0)
            return memo[n];
        memo[n] = plusOneTwoThree(n-1)+plusOneTwoThree(n-2)+plusOneTwoThree(n-3);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            System.out.println(plusOneTwoThree(n));
        }
        sc.close();
    }
}