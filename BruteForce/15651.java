import java.io.*;
import java.util.*;

public class Main {
    static int[] a = new int[10]; // 값을 저장하는 배열
    static StringBuilder res = new StringBuilder();

    static void go(int index, int n, int m){
        if(index == m){
            for(int i = 0; i < m; i++){
                res.append(a[i]);
                if(i != m-1)
                    res.append(' ');
            }
            res.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            a[index] = i;
            go(index+1, n, m);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        go(0, N, M);
        System.out.println(res);
    }
}