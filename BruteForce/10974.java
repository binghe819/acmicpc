import java.util.*;
import java.io.*;

// 백트래킹으로 푸는 방식.
public class Main {

    static int[] res = new int[9];
    static boolean[] check = new boolean[9];

    public static void go(int index, int n){
        if(index == n){
            for(int i = 0; i < n; i++){
                System.out.print(res[i]);
                if(i != n-1)
                    System.out.print(' ');
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!check[i]){
                check[i] = true;
                res[index] = i;
                go(index+1, n);
                check[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        go(0, N);

    }
}
