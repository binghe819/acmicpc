import java.util.*;
import java.io.*;

// 브루트포스 재귀를 사용한 풀이방법
public class Main {

    public static int[] res = new int[11];
    public static int result = 0;

    public static void go(int index, int sum, int n){
        if(sum > n) // 불가능한 경우
            return;
        if(sum == n){ // 정답을 찾은 경우
//            for(int i = 0; i < index; i++){
//                System.out.print(res[i]);
//                if(i != index-1)
//                    System.out.print(' ');
//            }
//            System.out.println();
//            return;
            result++;
            return;
        }

        // 1부터 3까지 다음 레벨로 들어간다.
        for(int i = 1; i <=3 ; i++){
            if(sum+i <= n){
                res[index] = i;
                go(index+1, sum+i, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            result = 0;
            go(0, 0, n);
            System.out.println(result);
        }

    }
}
