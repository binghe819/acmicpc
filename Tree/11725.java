import java.io.*;
import java.util.*;

// bfs를 이용한 풀이 (꼭 LinkedList로 풀어줘야한다.)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 입력
        LinkedList<Integer>[] graph = (LinkedList<Integer>[]) new LinkedList[N+1];
        for(int i = 1; i <= N; i++){
            graph[i] = new LinkedList<>();
        }
        String[] input;
        for(int i = 0; i < N-1; i++){
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            graph[from].add(to);
            graph[to].add(from);
        }

        // bfs
        int[] parent = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int n : graph[now]){
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                    parent[n] = now;
                }
            }
        }

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }
}