import java.io.*;
import java.util.*;

// 비트마스크를 이용한 풀이.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = 0; // 비트마스크 집합
        int M = Integer.parseInt(br.readLine());
        StringBuilder res = new StringBuilder();

        while(M-- > 0){
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int x;
            switch (command){
                case "add":
                    x = Integer.parseInt(input[1]);
                    S = S | (1 << x);
                    break;

                case "remove":
                    x = Integer.parseInt(input[1]);
                    S = S & ~(1 << x);
                    break;

                case "check":
                    x = Integer.parseInt(input[1]);
                    if((S & (1 << x)) > 0)
                        res.append(1+"\n");
                    else
                        res.append(0+"\n");
                    break;

                case "toggle":
                    x = Integer.parseInt(input[1]);
                    S = S ^ (1 << x);
                    break;

                case "all":
                    S = (1 << 21)-1;
                    break;

                case "empty":
                    S = 0;
                    break;
            }
        }

        System.out.println(res);
    }
}