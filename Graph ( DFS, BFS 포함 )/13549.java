import java.io.*;
import java.util.*;

// BFS (큐)를 이용한 풀이
public class Main {
    public static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] distance = new int[MAX];
        Arrays.fill(distance,-1); // -1은 방문한 적이 없음을 의미.

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        distance[N] = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == K)
                break;

            // +
            if(now+1 < MAX){
                // 방문한 적이 없거나, 방문해도 거리가 더 짧다면 (거리의 최소값 찾기)
                if(distance[now+1] == -1 || distance[now+1] > distance[now] + 1){
                    distance[now+1] = distance[now] + 1;
                    queue.offer(now+1);
                }

            }

            // -
            if(now - 1 >= 0){
                // 방문한 적이 없거나, 방문해도 거리가 더 짧다면 (거리의 최소값 찾기)
                if(distance[now-1] == -1 || distance[now-1] > distance[now] + 1) {
                    distance[now-1] = distance[now] + 1;
                    queue.offer(now-1);
                }

            }

            // *2
            if(now*2 <= MAX){
                // 방문한 적이 없거나, 방문해도 거리가 더 짧다면 (거리의 최소값 찾기)
                if(distance[now*2] == -1 || distance[now*2] > distance[now]){
                    distance[now*2] = distance[now];
                    queue.offer(now*2);
                }
            }
        }

        System.out.println(distance[K]);

    }
}