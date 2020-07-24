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

public class Main {

    public static final int[] dx = {-2, -2, -1, -1, 1 , 1, 2, 2};
    public static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        while(T-- > 0){
            int I = Integer.parseInt(br.readLine());

            // 방문하지 않은 위치를 -1로 표시
            int[][] board = new int[I][I];
            for(int i = 0; i < I; i++){
                Arrays.fill(board[i], -1);
            }

            Queue<Pair> queue = new LinkedList<>();
            // 시작점 (queue에 바로 넣기)
            String[] input = br.readLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            queue.offer(new Pair(startX, startY)); // 시작점 Enqueue
            board[startX][startY] = 0; // 방문 한 것이며, 시작점이므로 0으로 초기화

            // 도착점
            input = br.readLine().split(" ");
            Pair end = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));

            // bfs
            int x, y, xn, yn;
            while(!queue.isEmpty()){
                Pair now = queue.poll();
                x = now.x;
                y = now.y;
                if(x == end.x && y == end.y)
                    break;
                for(int i = 0; i < 8; i++){
                    xn = x + dx[i];
                    yn = y + dy[i];
                    if(xn >= 0 && xn < I && yn >= 0 && yn < I){
                        if(board[xn][yn] == -1){
                            queue.offer(new Pair(xn, yn));
                            board[xn][yn] = board[x][y]+1;
                        }
                    }
                }
            }

            System.out.println(board[end.x][end.y]);
        }
    }
}