import java.io.*;
import java.util.*;

// 조합을 사용한 풀이방식
public class Main {

    static int[] nums;
    static int result = 0;
    static boolean[] check = new boolean[21];
    static int[] res = new int[21];
    static int S;

    public static void combination(int index, int num, int m, int n){
        if(index == m){
            int tmp = 0;
            for(int i = 0; i < m; i++){
                tmp+=res[i];
            }
            if(tmp == S)
                result++;
            return;
        }

        if(num > n-1)
            return;

        // O
        res[index] = nums[num];
        combination(index+1, num+1, m, n);

        // X
        combination(index, num+1, m, n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        nums = new int[N];

        String[] inputNums = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(inputNums[i]);
        }

        for(int i = 1 ; i <= N; i++){
            combination(0, 0, i, N);
        }

        System.out.println(result);
    }
}