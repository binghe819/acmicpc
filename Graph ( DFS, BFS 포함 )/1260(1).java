import java.io.*;
import java.util.*;

// 인접 리스트 사용한 풀이
public class Main {

    static int V; // node
    static int E; // edge
    static boolean[] visited;
    static LinkedList<LinkedList<Integer>> graph;

    public static void dfs_r(int node){
        if(visited[node])
            return;
        visited[node] = true;
        System.out.print(node+" ");
        for(int n : graph.get(node)){
            dfs_r(n);
        }
//        for(int i = 0; i < graph.get(node).size(); i++){
//            dfs_r(graph.get(node).get(i));
//        }
    }

    public static void bfs(int node){
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        int tmp;
        while(!queue.isEmpty()){
            tmp = queue.poll();
            System.out.print(tmp +" ");
            for(int n : graph.get(tmp)){
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                }
            }
//            for(int i = 0; i < graph.get(tmp).size(); i++){
//                int next = graph.get(tmp).get(i);
//                if(!visited[next]){
//                    visited[next] = true;
//                    queue.offer(next);
//                }
//            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        int startPoint = Integer.parseInt(input[2]);
        graph = new LinkedList<LinkedList<Integer>>();
        visited = new boolean[V+1];

        for(int i = 0; i <= V; i++){
            graph.add(new LinkedList<>());
        }

        while(E-- > 0){
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 1; i <= V; i++){
            Collections.sort(graph.get(i));
        }

        dfs_r(startPoint);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(startPoint);

    }
}