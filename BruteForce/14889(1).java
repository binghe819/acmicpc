import java.io.*;
import java.util.*;

// 비트마스크를 사용한 풀이
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[][] S = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                S[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = 10000001;
        ArrayList<Integer> teamA = new ArrayList<>();
        ArrayList<Integer> teamB = new ArrayList<>();


        // 비트마스크를 사용한 조합
        for(int i = 1; i < (1 << N); i++){ // N = 4를 기준으로 0001부터 1111까지 루프
            for(int j = 0; j < N; j++){ // 0부터 N까지 돌면서 비트의 인덱스가 1인지 0인지 확인하는 루프
                if((i & (1 << j)) == 0) // 만약 j (인덱스)가 0이라면 팀 A로
                    teamA.add(j);
                else
                    teamB.add(j);
            }
            if(teamA.size() == (N/2) && teamB.size() == (N/2)){
                int ta = 0;
                int tb = 0;
                for(int k = 0; k < (N/2); k++){
                    for(int q = 0; q < (N/2); q++){
                        if(k == q) continue;
                        ta += S[teamA.get(k)][teamA.get(q)];
                        tb += S[teamB.get(k)][teamB.get(q)];
                    }
                }
                int diff = Math.abs(ta - tb);
                if(result > diff)
                    result = diff;
            }
            teamA.clear();
            teamB.clear();
        }
        System.out.println(result);
    }
}