import java.io.*;
import java.util.*;

// 브루트포스 방법
public class Main {

    static boolean[] check = new boolean[10]; // 숫자 사용 체크
    static ArrayList<String> res = new ArrayList<>();
    static int[] nums;
    static char[] symbols;

    // 부등호에 맞는지 확인하는 메서드
    public static boolean checkCorrect(String num, int k){
        boolean check = false;
        for(int i = 0; i < k; i++){
            if(symbols[i] == '<'){
                if(num.charAt(i)-'0' > num.charAt(i+1)-'0')
                    return false;
            } else {
                if(num.charAt(i)-'0' < num.charAt(i+1)-'0')
                    return false;
            }
        }
        return true;
    }

    // index : 지금까지 선택한 숫자
    // num : 지금까지 고른 숫자들의 문자열 (이전의 res와 같다.)
    // m : 최대 자리수
    public static void permutation(int index, String num, int k){
        // 경우의 수
        if(index == k+1){ // 부등호가 2개면 숫자는 3개 필요하므로 k+1
            if(checkCorrect(num, k)){
                res.add(num);
            }
            return;
        }

        for(int i = 0; i < 10; i++){
            if(!check[i]){
                check[i] = true;
                permutation(index+1, num+Integer.toString(i), k);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int k = Integer.parseInt(br.readLine());
        symbols = new char[k];
        nums = new int[k];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < k; i++){
            symbols[i] = input[i].charAt(0);
        }

        // 순열로 부등호 조건 맞는 것 찾기
        permutation(0, "", k);

        Collections.sort(res); // 정렬

        System.out.println(res.get(res.size()-1));
        System.out.println(res.get(0));
    }
}