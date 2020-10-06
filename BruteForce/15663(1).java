import java.io.*;
import java.util.*;

public class Main {

    static int[] digits;
    static int[] num = new int[9];
    static StringBuilder res = new StringBuilder();
    static boolean[] check = new boolean[9]; // 전체 중복 체크

    public static void go(int depth, int n, int m) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                res.append(num[i]);
                if(i != m-1) {
                    res.append(' ');
                }
            }
            res.append("\n");
            return;
        }

        boolean[] checkDepth = new boolean[10001]; // 같은 depth의 중복 체크
        for(int i = 0; i < n; i++) {
            if(!checkDepth[digits[i]]) { // 같은 depth의 중복된 숫자 체크
                if(!check[i]) {
                    checkDepth[digits[i]] = true;
                    check[i] = true;
                    num[depth] = digits[i];
                    go(depth+1, n, m);
                    check[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        digits = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            digits[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(digits);

        go(0, N, M);
        System.out.print(res);
    }
}
