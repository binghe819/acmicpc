import java.io.*;
import java.util.*;

// bfs를 사용한 풀이방식
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void bfs(int[][] map, int[][] group, int x, int y, int n, int cnt){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));
        group[x][y] = cnt;

        while(!queue.isEmpty()){
            Pair location = queue.poll();
            for(int i = 0; i < 4; i++){
                int xn = location.x + dx[i];
                int yn = location.y + dy[i];

                if( xn >= 0 && xn < n && yn >= 0 && yn < n){ // 좌 우 상 하로 갈 수 있는 지 체크
                    if(map[xn][yn] == 1 && group[xn][yn] == 0){ // 아파트가 있으면서 방문한 적 없는 곳이면
                        group[xn][yn] = cnt;
                        queue.offer(new Pair(xn, yn));
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split("");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // bfs로 모든 map을 탐색하면서 단지 번호 붙이기
        int cnt = 0;
        int[][] group = new int[N][N]; // 각 위치별 단지 번호 저장하는 배열
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && group[i][j] == 0){
                    bfs(map, group, i, j, N, ++cnt);
                }
            }
        }

        // 단지별 개수 세기
        int[] ans = new int[cnt];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(group[i][j] > 0){
                    ans[group[i][j]-1]++;
                }
            }
        }

        // 정렬 및 결과 출력
        Arrays.sort(ans);
        System.out.println(ans.length);
        for(int n : ans){
            System.out.println(n);
        }

    }
}