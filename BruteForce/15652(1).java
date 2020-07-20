import java.io.*;
import java.util.*;

// 조합을 사용한 풀이
public class Main {

    static int[] res;

    public static void combination(int index, int num, int n, int m){
        if(index == m){
            for(int i = 0; i < m; i++){
                System.out.print(res[i]);
                if(i != m-1)
                    System.out.print(' ');
            }
            System.out.println();
            return;
        }

        // 만약 num이 n을 넘었으면 return
        if(num > n)
            return;

        // O
        res[index] = num;
        combination(index+1, num, n, m);

        // X
        combination(index, num+1, n, m);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        res = new int[M];

        combination(0, 1, N, M);
    }
}