import java.util.*;

public class Main {

    static boolean[] broken_nums;
    public static int check_broken(int n){
        if(n == 0){
            if(broken_nums[0])
                return 0;
            else
                return 1;
        }
        int len = 0;
        while(n > 0){
            if(broken_nums[n%10]) // 만약 고장난 번호라면.
                return 0;
            len++;
            n /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        broken_nums = new boolean[10];

        while(M-- > 0){
            broken_nums[sc.nextInt()] = true;
        }

        int result = N - 100;
        if(result < 0)
            result *= -1;

        for(int i = 0; i <= 1000000; i++){
            int len = check_broken(i); // 번호를 누른 횟수.
            if(check_broken(i) > 0){
                int distance = i - N; // 누른 번호와 원하는 정답과의 거리.
                // 절대값
                if( distance < 0 )
                    distance *= -1;
                if(distance + len < result)
                    result = distance + len;
            }
        }

        System.out.println(result);
        sc.close();
    }
}