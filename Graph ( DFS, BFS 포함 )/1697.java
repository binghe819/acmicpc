import java.io.*;
import java.util.*;

public class Main {

    public static final int MAX = 100001;

    public static void bfs(int N, int K){
        int[] visited = new int[100001]; // 각 정점의 거리
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = 1; // 수빈이의 첫 위치가 1

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == K) // 만약 동생의 위치에 도착했다면
                break;

            // x-1이 0보다 크고 아직 방문한 적 없는 정점이라면. ( x-1 )
            if(now-1 >= 0 && visited[now-1] == 0){
                queue.offer(now-1);
                visited[now-1] = visited[now] + 1;
            }

            // x+1이 아직 방문한 적 없는 정점이라면. ( x + 1 )
            if(now+1 < MAX && visited[now+1] == 0){
                queue.offer(now+1);
                visited[now+1] = visited[now] + 1;
            }

            // 2x가 아직 방문한 적 없는 정점이라면 ( 2x )
            if(2*now < MAX && visited[2*now] == 0){
                queue.offer(2*now);
                visited[2*now] = visited[now] + 1;
            }
        }
        System.out.println(visited[K]-1); // 동생을 찾은 위치까지의 거리
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        bfs(N, K);

    }
}