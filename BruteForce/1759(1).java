import java.util.*;
import java.io.*;

// 조합(선택)을 사용하는 풀이방식
public class Main {

    // password에 모음과 자음의 개수를 확인하는 함수
    public static boolean check(String password){
        int moum = 0;
        int zaum = 0;
        for(char ch : password.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                moum++;
            else
                zaum++;
        }
        if(moum >= 1 && zaum >= 2)
            return true;
        return false;
    }

    // index = 가능한 알파벳 배열의 인덱스
    // L = 암호의 길이
    // password = 지금까지 선택한 암호
    // alpha = 가능한 알파벳 배열
    public static void go(int index, int L, String password, char[] alpha){
        if(password.length() == L){
            if(check(password))
                System.out.println(password);
            return;
        }

        // index는 가능한 알파벳의 인덱스이다.
        // 만약 index가 alpha의 길이보다 커진다면 다음 알파벳은 없기때문에 return해준다.
        if(index >= alpha.length)
            return;
        // O
        go(index+1, L, password+alpha[index], alpha);
        // X
        go(index+1, L, password, alpha);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] input = br.readLine().split(" ");
        int L = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        char[] alpha = new char[C];

        // L개의 알파벳 입력
        String[] alphaInput = br.readLine().split(" ");
        for(int i = 0; i < C; i++){
            alpha[i] = alphaInput[i].charAt(0);
        }
        Arrays.sort(alpha);

        go(0, L, "", alpha);

    }
}
