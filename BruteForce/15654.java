import java.io.*;
import java.util.*;

public class Main {

    static int[] nums;
    static int[] a = new int[10];
    static boolean[] check = new boolean[10];

    static void go(int index, int n, int m){
        if(index == m){
            for(int i = 0; i < m; i++){
                System.out.print(a[i]);
                if(i != m-1)
                    System.out.print(' ');
            }
            System.out.println();
            return;
        }

	// 입력값을 받은 배열을 루프돌기
        for(int i = 0; i < n; i++){
            if(!check[i]){
                a[index] = nums[i];
                check[i] = true;
                go(index+1, n, m);
                check[i] = false;
            }

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 M 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        //  N의 숫자들 입력
        nums = new int[N];
        String[] inputNum = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(inputNum[i]);
        }
        // 정렬
        Arrays.sort(nums);

        go(0, N, M);
    }
}