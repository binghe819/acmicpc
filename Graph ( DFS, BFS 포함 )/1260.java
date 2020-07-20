import java.io.*;
import java.util.*;

// 인접 리스트를 사용한 풀이
public class Main {

    static int V; // node
    static int E; // edge
    static boolean[] visited;
    static int[][] graph;

    public static void dfs_r(int node){
        if(visited[node])
            return;
        visited[node] = true;
        System.out.print(node+" ");
        for(int i = 1; i <= V; i++){
            if(graph[node][i] == 1){
                dfs_r(i);
            }
        }
    }

    public static void bfs(int node){
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        int tmp;
        while(!queue.isEmpty()){
            tmp = queue.poll();
            System.out.print(tmp+" ");
            for(int i = 1; i <= V; i++){
                if(graph[tmp][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        int startPoint = Integer.parseInt(input[2]);
        graph = new int[V+1][V+1];
        visited = new boolean[V+1];

        while(E-- > 0){
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            graph[from][to] = graph[to][from] = 1;
        }

        dfs_r(startPoint);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(startPoint);
    }
}