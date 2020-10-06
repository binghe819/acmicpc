import javax.sound.midi.MidiSystem;
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

// 탐색 두 번을 사용한 풀이
public class Main {


    public static int[] bfs(LinkedList<Node>[] graph, int V, int start){
        int[] dist = new int[V+1]; // start노드에서 각 노드까지의 거리

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

        int V = Integer.parseInt(br.readLine());
        LinkedList<Node>[] graph = (LinkedList<Node>[]) new LinkedList[V+1];

        for(int i = 1; i<= V; i++){
            graph[i] = new LinkedList<>();
        }

        // 입력
        for(int i = 0; i < V; i++){
            String[] input = br.readLine().split(" ");

            int node = Integer.parseInt(input[0]);
            int length = input.length;
            for(int j = 1; j < length-1; j+=2){
                // node에서 to까지의 거리(distance)
                int to = Integer.parseInt(input[j]);
                int distance = Integer.parseInt(input[j+1]);
                graph[node].add(new Node(to, distance));
            }
        }

        // 정점 1에서 각 노드로 가는 길이 구하기 (탐색 한 번)
        int start = 1;
        int[] dist = bfs(graph, V, start); // 정점 1에서 각 노드로 가는 길이
        for(int i = 2; i <= V; i++){
            if(dist[i] > dist[start])
                start = i;
        }

        // 정점 1에서 제일 먼 노드에서 다시 한번 길이가 제일 긴 정점 구하기 (탐색 두 번)
        dist = bfs(graph, V, start);
        int ans = dist[1];
        for(int i = 2; i<= V; i++){
            if(dist[i] > ans)
                ans = dist[i];
        }
        System.out.println(ans);
    }
}