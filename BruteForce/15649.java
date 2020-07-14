import java.io.*;
import java.util.*;

public class Main {

    static boolean[] check = new boolean[10];
    static int[] num = new int[10];

    // index = level (숫자 자리수 = 트리의 레벨)
    public static void go(int index, int n, int m){
        // 자리수가 m만큼 됐다면(재의 깊이가 m만큼 됐다면)
        if(index == m){
            // 출력
            for(int i = 0; i < m; i++){
                System.out.print(num[i]);
                if(i != m-1)
                    System.out.print(' ');
            }
            System.out.println();
            return;
        }

        // 재 돌기.
        for(int i = 1; i <= n; i++){
            if(!check[i]){
                check[i] = true;
                num[index] = i; // 현재 인덱스에서 아직 사용하지 않는 숫자 넣기
                go(index+1, n, m); // 다음 인덱스로 실행 ( 트리의 다음 깊이로 진입 )
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        go(0, N, M);
    }
}