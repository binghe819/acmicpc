import java.io.*;
import java.util.*;

// 두 개의 큐를 이용한 풀이 ( BFS )
public class Main {
    public static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        boolean[] visited = new boolean[MAX];
        int[] distance = new int[MAX];

        Queue<Integer> queue_now = new LinkedList<>();
        Queue<Integer> queue_next = new LinkedList<>();

        queue_now.offer(N);
        distance[N] = 0;
        visited[N] = true;

        while(!queue_now.isEmpty()){
            int now = queue_now.poll();

            // x+1, x-1, x*2
            for(int next : new int[]{now+1, now-1, now*2}){
                if(next >=0 && next < MAX){
                    if(!visited[next]){
                        visited[next] = true;
                        if(next == now*2){ // 이동하는데 시간이 걸리지 않는 now*2 체크
                            queue_now.offer(next);
                            distance[next] = distance[now]; // 0초
                        } else { // x+1, x-1이라면 다음 큐에 넣기
                            queue_next.offer(next);
                            distance[next] = distance[now] + 1; // 1
                        }
                    }
                }
            }
            // 만약 현재 큐에 더이상 넣을 게 없다면 큐를 한단계 앞으로 이동시키기.
            if(queue_now.isEmpty()){
                queue_now = queue_next;
                queue_next = new LinkedList<>();
            }
        }

        System.out.println(distance[K]);

    }
}