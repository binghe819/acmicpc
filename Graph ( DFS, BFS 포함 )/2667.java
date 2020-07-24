import java.util.*;

// dfs를 사용한 풀이
public class Main {
	
	static int[][] map = new int[26][26];
	static int num;
	// 왼쪽, 오른쪽, 아래, 위를 훑기 위한 배열
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int room_num; // 집의 개수를 세기위한 변수
	
	public static void dfs(int i, int j) {
		// i가 y값이고, j가 x값이다.
		room_num++;
		map[i][j] = 0; // 방문 체크.
		for(int k = 0; k < 4; k++) {
			// 맵의 범위를 벗어나는지 체크
			if(i + dy[k] <0 || i + dy[k] >=num || j + dx[k] < 0 || j + dx[k] >= num)
				continue;
			// 왼, 오, 아, 위 중에서 1을 찾았다면 dfs재귀.
			if(map[i+dy[k]][j+dx[k]]==1) {
				dfs(i+dy[k],j+dx[k]);
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 결과를 저장하기 위한 배열
		ArrayList<Integer> result = new ArrayList<Integer>();
		String tmp;
		// 사이즈 입력
		num = sc.nextInt();
		
		// 지도 입력
		for(int i = 0; i < num; i++) {
			 tmp = sc.next();
			 for(int j = 0; j < num; j++) {
				 map[i][j] = tmp.charAt(j)-'0';
			 }
		}
		
		// 지도 훎기
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				if(map[i][j] == 1) {
					room_num = 0;
					dfs(i, j);
					result.add(room_num);
				}
			}
		}
		
		// 결과배열 오름채순
		Arrays.sort(result);
		
		System.out.println(result.size());
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
		sc.close();
	}
}