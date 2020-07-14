import java.util.*;
import java.io.*;

// 백트래킹으로 푸는 방법
public class Main {

    static int[] nums;
    static int[] res = new int[9];
    static boolean chech[] = new boolean[9];
    static int result = 0;

    public static void go(int index, int n){
        if(index == n){
            int tmp = 0;
            for(int i = 0; i < n-1; i++){
                tmp+=Math.abs(res[i]-res[i+1]);
            }
            if(tmp > result)
                result = tmp;
            return;
        }

        for(int i = 0; i < n; i++){
            if(!chech[i]){
                chech[i] = true;
                res[index] = nums[i];
                go(index+1, n);
                chech[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        go(0, N);
        System.out.println(result);
    }
}