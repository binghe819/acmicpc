import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {

    static boolean[] visited;
    static int[][] graph;
    static int result;
    static int V;
    static int E;

    public static void dfsR(int node){
        if(visited[node])
            return;
        visited[node] = true;
        for(int i = 1; i <= V; i++){
            if(graph[node][i] == 1){
                graph[node][i] = 0;
                dfsR(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        graph = new int[1001][1001];
        visited = new boolean[100001];

        for(int i = 0; i < E; i++){
            String[] inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);

            graph[from][to] = graph[to][from] = 1; // 단방향 간선
        }

        // 모든 정점을 돌면서 연결 요소의 개수를 탐색.
        for(int i = 1; i <= V; i++){
            if(!visited[i]){
                result++;
                dfsR(i);
            }
        }

        System.out.println(result);
    }
}