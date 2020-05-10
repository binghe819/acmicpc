import java.util.*;
import java.io.*;

public class Main {

    static int[] memo = new int[1000001];

    public static int makeOne(int n){
        if(n == 1)
            return 0;
        if(memo[n] > 0) // 메모이제이션에 저장되어있다면
            return memo[n];
        // 최소값 찾기
        memo[n] = makeOne(n-1) + 1;
        if(n % 3 == 0){
            int temp = makeOne(n/3)+1;
            if(temp < memo[n])
                memo[n] = temp;
        }
        if(n % 2 == 0){
            int temp = makeOne(n/2)+1;
            if(temp < memo[n])
                memo[n] = temp;
        }
        return memo[n];
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(makeOne(N));
        sc.close();
    }
}