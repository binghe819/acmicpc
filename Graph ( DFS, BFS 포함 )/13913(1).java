import java.io.*;
import java.util.*;

// 재귀를 이용한 백트래킹
public class Main {

    public static final int MAX = 100001;

    public static void bfs(int N, int K){
        int[] distance = new int[100001];
        int[] tracking = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        distance[N] = 1; // 수빈이의 첫 위치
        tracking[N] = -1; // 백트래킹의 목적지 ( 수빈이의 첫 위치 )

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == K) // 수빈이가 동생의 위치에 도착했다면
                break;

            if(now-1 >= 0 && distance[now-1] == 0){
                queue.offer(now-1);
                distance[now-1] = distance[now] + 1;
                tracking[now-1] = now;
            }

            if(now+1 < MAX && distance[now+1] == 0){
                queue.offer(now+1);
                distance[now+1] = distance[now] + 1;
                tracking[now+1] = now;
            }

            if(2*now < MAX && distance[2*now] == 0){
                queue.offer(2*now);
                distance[2*now] = distance[now] + 1;
                tracking[2*now] = now;
            }
        }
        System.out.println(distance[K]-1);
        printTracking(N, K, tracking);
    }

    public static void printTracking(int n, int m, int[] tracking){
        if(n != m)
            printTracking(n, tracking[m], tracking);
        System.out.print(m+" ");
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