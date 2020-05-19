import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int e = 1;
        int s = 1;
        int m = 1;

        // 1부터 반복문을 돈다.(년도)
        for(int i = 1 ; ; i++){
            // 입력한 값과 같아지면 출력하고 break;
            if(e == E && s == S && m == M){
                System.out.println(i);
                break;
            }
            e+=1;
            s+=1;
            m+=1;
            if(e == 16)
                e = 1;
            if(s == 29)
                s = 1;
            if(m == 20)
                m = 1;
        }
        sc.close();
    }
}