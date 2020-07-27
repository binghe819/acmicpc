import java.io.*;
import java.util.*;

class Pair { 
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 덱을 사용한 풀이 (BFS)
public class Main {

    public static final int[] dx = {0,0,1,-1};
    public static final int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); // 가로 (y)
        int N = Integer.parseInt(input[1]); // 세로 (x)

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++){
            input = br.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] distance = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        ArrayDeque<Pair> deque = new ArrayDeque<>();
        deque.offerFirst(new Pair(0,0));
        visited[0][0] = true;
        distance[0][0] = 0;

        while(!deque.isEmpty()){
            Pair now = deque.pollFirst();
            int x = now.x;
            int y = now.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        if(map[nx][ny] == 1){ // 벽이 있다면
                            deque.offerLast(new Pair(nx, ny));
                            distance[nx][ny] = distance[x][y] + 1;
                        } else { // 벽이 없다면
                            deque.offerFirst(new Pair(nx, ny));
                            distance[nx][ny] = distance[x][y];
                        }
                    }
                }
            }
        }

        System.out.println(distance[N-1][M-1]);
    }
}