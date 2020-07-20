import java.util.*;
import java.io.*;

// DP를 이용한 풀이
public class Main {

    static int[] memo = new int[17];
    static int[] T = new int[17]; // 걸리는 시간
    static int[] P = new int[17]; // 벌 수 있는 돈

    public static int solution(int n){
        if(n <= 0)
            return 0;
        if(memo[n] > 0)
            return memo[n];

        for(int i = 1; i < n; i++){
            if(i + T[i] <= n){
                 int tmp = solution(i) + P[i];
                 if(tmp >= memo[n])
                     memo[n] = tmp;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        System.out.println(solution(N+1));

    }
}