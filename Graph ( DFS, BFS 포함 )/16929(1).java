import java.io.*;

public class Main {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static int n;
    public static int m;
    public static char[][] map;
    public static boolean[][] visited;

    public static boolean dfs(int x, int y, int prevX, int prevY, char color){
        if(visited[x][y]) 
            return true;
        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                // 전 칸과 다음 칸이 서로 다르고, 다음 칸이 color라면
                if(!(prevX == nextX && prevY == nextY) && (map[nextX][nextY] == color)){
                    if(dfs(nextX, nextY, x, y, color))
                        return true;
                }
            }
        }
        return false;
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

        // 순회하며 사이클 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){ // 아직 방문한 적 없다면 
                    if(dfs(i, j, -1, -1, map[i][j])){
                        System.out.println("Yes");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("No");
    }
}