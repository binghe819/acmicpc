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

    public static final int[] dx = {1, 0, 0, -1};
    public static final int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]); // width
        int h = Integer.parseInt(input[1]); // heigh

        Queue<Pair> queue = new LinkedList<>();
        int[][] board = new int[h][w];
        int[][] map = new int[h][w];
        for(int i = 0; i < h; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < w; j++){
                map[i][j] = Integer.parseInt(input[j]);
                board[i][j] = -1;
                if(map[i][j] == 1){
                    board[i][j] = 0;
                    queue.offer(new Pair(i,j));
                }

            }
        }

        // bfs
        int x, y, xn, yn;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            x = pair.x;
            y = pair.y;
            for(int i = 0; i < 4; i++){
                xn = x + dx[i];
                yn = y + dy[i];
                if(xn >= 0 && xn < h && yn >= 0 && yn < w){
                    if(map[xn][yn] == 0 && board[xn][yn] == -1){
                        queue.add(new Pair(xn,yn));
                        board[xn][yn] = board[x][y] + 1;
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(map[i][j] == 0 && board[i][j] == -1){
                    System.out.println(-1);
                    System.exit(0);
                }
                if(board[i][j] > result)
                    result = board[i][j];
            }
        }
        System.out.println(result);
    }
}