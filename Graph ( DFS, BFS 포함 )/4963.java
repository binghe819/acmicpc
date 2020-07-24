import java.io.*;
import java.util.*;

// DFS를 사용한 문제 풀이
public class Main {
    public static final int[] dx = {0, 0, 1, -1, 1, 1, -1, -1}; // 높이
    public static final int[] dy = {1, -1, 0, 0, -1, 1, -1, 1}; // 넓이

    // x : 높이
    // y : 넓이
    public static void dfs(int[][] map, int x, int y, int w, int h){
        if(map[x][y] == 0)
            return;
        map[x][y] = 0;
        for(int i = 0; i < 8; i++){
            int xn = x + dx[i];
            int yn = y + dy[i];
            if(xn >= 0 && xn < h && yn >= 0 && yn < w){
                if(map[xn][yn] == 1){
                    dfs(map, xn, yn, w, h);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]); // 넓이
            int h = Integer.parseInt(input[1]); // 높이

            if(w == 0 && h == 0)
                break;

            // 지도 입력 받기
            int[][] map = new int[h][w];
            for(int i = 0; i < h; i++){
                input = br.readLine().split(" ");
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            int cnt = 0;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(map[i][j] == 1){
                        dfs(map, i, j, w, h);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }
}