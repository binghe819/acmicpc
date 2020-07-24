import java.io.*;

// 재귀 dfs를 사용한 풀이
public class Main {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static int n;
    public static int m;
    public static char[][] map;
    public static boolean[][] visited;
    public static boolean result = false;

    public static void dfs(int[][] board, int x, int y, int cnt, char color){
        if(visited[x][y]){ // 만약 방문한 적 있고
            if(cnt-board[x][y] >= 4) // 시작점과 거리가 4차이난다면
                result = true; // 사이클 발견
            return;
        }

        visited[x][y] = true;
        board[x][y] = cnt;

        int xn, yn;
        for(int i = 0; i < 4; i++){
            xn = x + dx[i];
            yn = y + dy[i];
            if(xn >= 0 && xn < n && yn >= 0 && yn < m){
                if(map[xn][yn] == color){
                    dfs(board, xn, yn, cnt+1, color);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        // 입력
        map = new char[n][m];
        for(int i = 0; i < n; i++){
            input = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = input[j].charAt(0);
            }
        }

        // 방문 체크
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int[][] board = new int[n][m];
                if(!visited[i][j]){ // 아직 방문한 적 없는 칸이라면
                    dfs(board, i, j, 1, map[i][j]);
                    if(result){
                        System.out.println("Yes");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("No");
    }
}