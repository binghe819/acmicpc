import java.io.*;
import java.util.*;

// 선택방식풀이 ( O, X )
public class Main {

    static int[] S = new int[13];
    static int[] res = new int[13];
    static StringBuilder result = new StringBuilder();

    // index = 채워야 할 결과의 인덱스
    // num = S에서의 인덱스
    public static void combination(int index, int num, int k){
        if(index == 6){
            for(int i = 0; i < 6; i++){
                if(res[i] == 0)
                    return;
            }

            for(int i = 0; i < 6; i++){
                result.append(res[i]);
                if(i != 5)
                    result.append(' ');
            }
            result.append("\n");
            return;
        }

        if(num > k)
            return;

        // O
        res[index] = S[num];
        combination(index+1, num+1, k);

        // X
        combination(index, num+1, k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            if(k == 0)
                break;
            for(int i = 0; i < k; i++){
                S[i] = Integer.parseInt(input[i+1]);
            }
            combination(0, 0, k);
            result.append("\n");
        }
        System.out.println(result);
    }
}