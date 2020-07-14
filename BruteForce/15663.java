import java.util.*;
import java.io.*;

public class Main_buffer {

    static int[] nums = new int[10]; // 출력용
    static int[] inputNums; // 숫자 입력 배열
    static boolean[] check = new boolean[10];
    static boolean[][] numCheck = new boolean[10][10001]; // 10:재귀의 깊이, 10001은 입력값.
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
            if(!check[i]){
		// 같은 레벨에 중복된 값을 사용했는지 확인
                if(numCheck[index][inputNums[i]])
                    continue;
                numCheck[index][inputNums[i]] = true;

                check[i] = true;
                nums[index] = inputNums[i];
                go(index+1, n, m);
                check[i] = false;
            }
        }
	// 해당 레벨의 모든 값 초기화.
        for(int i = 0; i < n; i++){
            numCheck[index][inputNums[i]] = false;
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
