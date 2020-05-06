import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new 	OutputStreamWriter(System.out));//선언
        Queue<Integer> queue = new LinkedList<>();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for(int i = 1 ; i <= N; i++)
            queue.offer(i);

        StringBuilder result = new StringBuilder();
        result.append("<");

        // 큐의 데이터가 빌 때까지
        while(!queue.isEmpty()){
            // K-1번씩 큐의 앞부분과 뒷부분의 숫자를 바꿔주기.
            for(int i = 0 ; i < K-1; i++){
                queue.offer(queue.poll());
            }
            result.append(queue.poll()+", ");
        }

        result.replace(result.length()-2, result.length()-1, ">");
        System.out.println(result);
    }

}