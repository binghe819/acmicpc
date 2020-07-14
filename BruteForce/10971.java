import java.util.*;
import java.io.*;

// 다음 순열로 푸는 방법
public class Main {

    public static boolean next_permutation(int[] a){
        // i 찾기
        int i = a.length-1;
        while(i > 0 && a[i-1] >= a[i]){
            i--;
        }
        if(i <= 0)
            return false;

        // j 찾기
        int j = a.length-1;
        while(a[i-1] >= a[j]){
            j--;
        }

        // swap
        int tmp = a[i-1];
        a[i-1] = a[j];
        a[j] = tmp;

        // Reverse
        j = a.length-1;
        while(i < j){
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] W = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 도시들의 이름을 인덱스로 한다.
        int[] index = new int[N];
        for(int i = 0; i < N; i++){
            index[i] = i;
        }

        // 최대값
        int result = 1000000*10;

        do {
            int tmp = 0;
            boolean checkZero = false; // 0이 나왔는지 확인용
            for(int i = 0; i < N-1; i++){
                if(W[index[i]][index[i+1]] == 0) // 0이라면 checkZero에 체크
                    checkZero = true;
                tmp += W[index[i]][index[i+1]];
            }
            if(checkZero) // checkZero가 true라면 continue
                continue;
            if(W[index[N-1]][index[0]] != 0){ // 마지막 도시와 첫 도시의 거리가 0이 아닌지도 체크.
                // 마지막 인덱스와 첫 인덱스의 길이를 구하는 코드.
                tmp += W[index[N-1]][index[0]];
                if(tmp < result) // 최소값 체크
                    result = tmp;
            }
        } while(next_permutation(index));
        System.out.println(result);
    }
}
