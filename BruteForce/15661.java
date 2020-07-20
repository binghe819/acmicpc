import java.io.*;
import java.util.*;

public class Main {
    static int[][] S; // S값.
    static int result = 10001; // 능력치 값의 최솟 값

    // people : A로 갈지 B로 갈지 결정하는 사람 인덱스
    // teamA : teamA의 리스트
    // teamB : teamB의 리스트
    public static void combination(int people, ArrayList<Integer> teamA, ArrayList<Integer> teamB, int n){
        // 만약 n명이 모두 팀에 들어갔다면
        if(people == n){
//            System.out.println("Team A : "+teamA.toString()+", Team B : "+teamB.toString());
            int t1 = 0;
            int t2 = 0;
            for(int i = 0; i < teamA.size(); i++){
                for(int j = 0; j < teamA.size(); j++){
                    if(i == j) continue;
                    t1 += S[teamA.get(i)][teamA.get(j)];
                }
            }

            for(int i = 0; i < teamB.size(); i++){
                for(int j = 0; j < teamB.size(); j++){
                    if(i==j) continue;
                    t2 += S[teamB.get(i)][teamB.get(j)];
                }
            }

            int diff = Math.abs(t1 - t2);
            if (result > diff)
                result = diff;
            return;
        }

        if(people > n)
            return;

        // teamA로 갈 경우 (team별로 1명 이상이기 때문에 팀마다 n명씩 차면 안된다)
        if(teamA.size() < n-1){
            teamA.add(people);
            combination(people+1, teamA, teamB, n);
            teamA.remove(teamA.size()-1);
        }


        // teamB로 갈 경우
        if(teamB.size() < n-1){
            teamB.add(people);
            combination(people+1, teamA, teamB, n);
            teamB.remove(teamB.size()-1);
        }
        return;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        S = new int[N+1][N+1];
        ArrayList<Integer> teamA = new ArrayList<>();
        ArrayList<Integer> teamB = new ArrayList<>();
        // 입력
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                S[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 조합
        combination(0, teamA, teamB, N);
        System.out.println(result);
    }
}