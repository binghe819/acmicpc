import java.util.*;
import java.io.*;

// 순열을 사용하는 방법
public class Main {

    static boolean[] check = new boolean[16];
    static char[] res = new char[16];
    static char[] alpha;

    // index = 암호의 길이
    // start = 매 레벨마다 암호를 입력하는 시작인덱스
    // moum = 모음의 개수
    // zaum = 자음의 개수
    public static void go(int index, int start, int moum, int zaum, int L, int C){
        if(index == L){
            if(moum >= 1 && zaum >= 2){
                for(int i = 0; i < L; i++){
                    System.out.print(res[i]);
                }
                System.out.println();
            }
            return;
        }

        for(int i = start; i < C; i++){
            if(!check[i]){
                check[i] = true;
                if(alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u'){
                    res[index] = alpha[i];
                    go(index+1, i+1, moum+1, zaum, L, C);
                } else {
                    res[index] = alpha[i];
                    go(index+1, i+1, moum, zaum+1, L, C);
                }
                check[i] = false;
            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] input = br.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        alpha = new char[C];

        // L개의 알파벳 입력
        String[] alphaInput = br.readLine().split(" ");
        for(int i = 0; i < C; i++){
            alpha[i] = alphaInput[i].charAt(0);
        }
        Arrays.sort(alpha);

        go(0, 0, 0,0, L, C);
    }
}
