import java.io.*;
import java.util.*;

// Deque를 사용한 풀이 ( BFS )
public class Main {
    public static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        boolean[] visited = new boolean[MAX];
        int[] distance = new int[MAX];

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(N);
        visited[N] = true;
        distance[N] = 0;

        while(!deque.isEmpty()){
            int now = deque.pollFirst(); // 덱의 앞부분을 빼준다. (pollFirst() == poll())
            for(int next : new int[]{now+1, now-1, now*2}){
                if(next >= 0 && next < MAX){
                    if(!visited[next]){
                        visited[next] = true;
                        if(next == now*2){ // 이동하는데 시간이 걸리지 않는 now*2 체크
                            deque.offerFirst(next); // 덱의 앞으로 넣어준다.
                            distance[next] = distance[now];
                        } else { // x+1, x-1이라면 다음 큐에 넣기
                            deque.offerLast(next); // 덱의 뒤로 넣어준다.
                            distance[next] = distance[now] + 1;
                        }
                    }
                }
            }
        }

        System.out.println(distance[K]);

    }
}