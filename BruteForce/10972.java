import java.util.*;
import java.io.*;

public class Main {

    public static boolean next_permutation(int[] num) {

        // 오름차순 중 제일 마지막 수를 찾는다.
        int i = num.length-1; // 수열 마지막 수의 인덱스
        while(i > 0 && num[i-1] >= num[i]){
            i--;
        }
        if(i <= 0) // 만약 다음 수열이 없다면
            return false;

        // i-1번째 수의 다음 순열 수 찾기
        int j = num.length-1;
        while(num[i-1] >= num[j]){
            j--;
        }

        // i와 j교환
        int tmp = num[i-1];
        num[i-1] = num[j];
        num[j] = tmp;

        // i번째 이후의 첫 순열을 찾아준다. (리버스)
        j = num.length-1;
        while(i < j){
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            i += 1;
            j -= 1;
        }
        return true;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(input[i]);
        }

        if(next_permutation(num)){
            for(int i = 0; i < num.length; i++){
                System.out.print(num[i]+" ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }
}