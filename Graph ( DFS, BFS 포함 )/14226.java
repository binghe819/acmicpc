import java.io.*;
import java.util.*;

class Pair {
    int display;
    int clip;

    public Pair(int display, int clip) {
        this.display = display;
        this.clip = clip;
    }
}

public class Main {
    public static final int MAX = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int S = Integer.parseInt(br.readLine());

        // distance : depth ( -1은 아직 방문하지 않은 정점 )
        int[][] distance = new int[MAX][MAX];
        for(int i = 0; i < MAX; i++){
            Arrays.fill(distance[i],-1);
        }

        // bfs
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, 0));
        distance[1][0] = 0; // 시작 정점

        while(!queue.isEmpty()){
            Pair now = queue.poll();
            int display = now.display;
            int clip = now.clip;
            int depth = distance[display][clip];

            if(display == S)
                break;

            // 복사
            if(display > 0 && distance[display][display] == -1){
                queue.offer(new Pair(display, display));
                distance[display][display] = depth + 1;
            }

            // 붙여넣기
            if(display+clip <= S && distance[display+clip][clip] == -1){
                queue.offer(new Pair(display+clip, clip));
                distance[display+clip][clip] = depth + 1;
            }

            // 삭제
            if(display-1 > 0 && distance[display-1][clip] == -1){
                queue.offer(new Pair(display-1, clip));
                distance[display-1][clip] = depth + 1;
            }
        }

        // 최소값 찾기
        int result = MAX;
        for(int i = 0; i < MAX; i++){
            if(distance[S][i] < result && distance[S][i] != -1)
                result = distance[S][i];
        }

        System.out.println(result);

    }
}