import java.io.*;
import java.util.*;

class Node {
    int to;
    int distance;

    public Node(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}

public class Main {

    public static int[] bfs(LinkedList<Node>[] graph, int V, int start){
        int[] dist = new int[V+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        boolean[] visited = new boolean[V+1];
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(Node n : graph[node]){
                int to = n.to;
                int distance = n.distance;
                if(!visited[to]){
                    queue.offer(to);
                    dist[to] = dist[node] + distance;
                    visited[to] = true;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Node>[] graph = (LinkedList<Node>[]) new LinkedList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < n-1; i++){
            String[] input = br.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int distance = Integer.parseInt(input[2]);

            graph[node].add(new Node(to, distance));
            graph[to].add(new Node(node, distance));
        }

        // 탐색 한 번
        int start = 1;
        int[] dist = bfs(graph, n, start);
        for(int i = 2; i <= n; i++){
            if(dist[i] > dist[start])
                start = i;
        }

        // 탐색 두 번
        dist = bfs(graph, n, start);
        int ans = dist[1];
        for(int i = 2; i <= n; i++){
            if(dist[i] > ans)
                ans = dist[i];
        }
        System.out.println(ans);
    }
}