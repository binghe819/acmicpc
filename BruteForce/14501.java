import java.util.*;
import java.io.*;


// Brute Force를 사용한 풀이방법
public class Main {

    static int result = 0;
    static int[] T = new int[1001];
    static int[] P = new int[1001];

    // n으로 n+1이 주어진다.
    public static void go(int day, int sum, int n) {
        // day가 n+1을 넘어가므로.
        if(day > n)
            return;
        if(day == n){
            if(sum > result)
                result = sum;
            return;
        }

        // O
        go(day+T[day], sum+P[day], n);

        // X
        go(day+1, sum, n);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        go(1, 0, N+1);

        System.out.println(result);

    }
}
