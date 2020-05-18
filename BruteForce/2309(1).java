import java.util.*;

// 모든 수를 더한 다음, 2개씩 빼서 100이면 exit하는 코드
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++){
            input[i] = sc.nextInt();
            sum+=input[i];
        }

        // 오름차순
        Arrays.sort(input);
        // 브루트 포스
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 9; j++){
                if(sum - input[i] - input[j] == 100){
                    for(int k = 0; k < 9; k++){
                        if(k == i || k == j)
                            continue;
                        System.out.println(input[k]);
                    }
                    System.exit(0);
                }
            }
        }


        sc.close();
    }
}