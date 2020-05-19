import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 1; ; i++){
            if((i-1)%15 + 1 == E && (i-1)%28 + 1 == S && (i-1)%19 +1 == M){
                System.out.println(i);
                break;
            }
        }

        sc.close();
    }
}