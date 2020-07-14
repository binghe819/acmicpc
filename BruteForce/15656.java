import java.util.*;
import java.io.*;

public class Main {

    static int[] nums = new int[10]; // 출력용
    static int[] inputNums; // 숫자 입력 배열
    static StringBuilder res = new StringBuilder();

    // start = 입력값 배열중 시작 인덱스번호.
    public static void go(int index, int n, int m){
        if(index == m){
            for(int i = 0; i < m; i++){
                res.append(nums[i]);
                if(i != m-1)
                    res.append(' ');
            }
            res.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            nums[index] = inputNums[i];
            go(index+1, n, m);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        inputNums = new int[N];
        String[] inputNum = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            inputNums[i] = Integer.parseInt(inputNum[i]);
        }
        Arrays.sort(inputNums);

        go(0, N, M);
        System.out.println(res);
    }
}
