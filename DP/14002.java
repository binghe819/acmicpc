import java.util.*;

public class Main {

    static int[] A;
    static int[] memo;
    static int[] visited;

    // 역추적.
    static void go(int p){
        if(p == -1) // 역추적할게 없다면 종료.
            return;
        go(visited[p]);
        System.out.print(A[p]+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        A = new int[N];
        memo = new int[N];
        visited = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt(); // 입력값.
            visited[i] = -1; // 모든 visited -1로 치환. (더이상 역추적할 게 없다는 표시를 위함.)
        }

        // LIS
        for(int i = 0; i < N; i++){
            memo[i] = 1;
            for(int j = 0; j < i; j++){
                if(A[i] > A[j] && memo[i] < memo[j]+1){
                    memo[i] = memo[j] + 1;
                    visited[i] = j;
                }
            }
        }

        int maxIdx = 0; // LIS중에서 최고값의 인덱스.
        int maxLIS = memo[0]; // LIS의 최대 개수.
        for(int i = 0; i < N; i++){
            if(memo[i] > maxLIS) {
                maxLIS = memo[i];
                maxIdx = i;
            }
        }
        System.out.println(maxLIS);
        go(maxIdx);
        sc.close();
    }
}