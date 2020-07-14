import java.io.*;
import java.util.*;

// 조합(선택)방식으로 푸는 방법
public class Main {
    static int[] nums = new int[10];

    // 조합 (선택방식)
    // index = 선택한 숫자의 수 ( 0 <= index < M )
    // num = 숫자 ( 1 <= num <= N )
    public static void combination(int index, int num, int n, int m){
        // 만약 길이만큼 선택했다면
        if(index == m){
            for(int i = 0; i < m; i++){
                System.out.print(nums[i]);
                if(i != m-1)
                    System.out.print(' ');
            }
            System.out.println();
            return;
        }

        // 만약 숫자가 n을 넘었다면 return
        if(num > n)
            return;

        // 숫자 선택 ( O )
        nums[index] = num;
        combination(index+1, num+1, n, m);

        // 숫자 선택 ( X )
        nums[index] = 0; // 굳이 안해줘도 상관 없다.
        combination(index, num+1, n, m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        combination(0,1, N, M);
    }
}