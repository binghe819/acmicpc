import java.io.*;

// 비트 마스크를 이용한 풀이방식
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int result = 0;

        int[] nums = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(input[i]);
        }

        // 탐색
        for(int i = 1; i < (1 << N); i++){ // 모든 부분수열 탐색
            int sum = 0;
            for(int k = 0; k < N; k++){ // k번째 자리 수가 포함되어있는지 확인
                if((i & (1 << k)) != 0){ // k번째 자리 수가 포함되어 있다면
                    sum += nums[k];
//                    System.out.print(k+" ");
                }
            }
            if(sum == S)
                result++;
        }
        System.out.println(result);
    }
}