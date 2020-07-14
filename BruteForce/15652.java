import java.io.*;
import java.util.*;

public class Main {
    
    static int[] nums = new int[10];
    static StringBuilder res = new StringBuilder();

    public static void go(int index, int start, int n, int m){
        if(index == m){
            for(int i = 0; i < m; i++){
                res.append(nums[i]);
                if(i != m-1)
                    res.append(' ');
            }
            res.append("\n");
            return;
        }

        // start부터 num 반
        for(int i = start; i <= n; i++){
            nums[index] = i;
            go(index+1, i, n, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        go(0, 1, N, M);
        System.out.println(res);
    }
}