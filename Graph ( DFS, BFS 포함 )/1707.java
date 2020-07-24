import java.util.*;

public class Main {
    public static void dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
        color[x] = c;
        for (int y : a[x]) {
            if (color[y] == 0) {
                dfs(a, color, y, 3-c);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

	    // graph만들어주기
            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
            for (int i=1; i<=n; i++) {
                a[i] = new ArrayList<Integer>();
            }

	    // 간선 연결
            for (int i=0; i<m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                a[u].add(v);
                a[v].add(u);
            }

	    // color : visited
            int[] color = new int[n+1];
            boolean ok = true;

	    // 각 정점별로 팀 나누기 (번호 매기기)
            for (int i=1; i<=n; i++) {
                if (color[i] == 0) {
                    dfs(a, color, i, 1);
                }
            }

	    // 각 정점별로 돌면서 같은 팀에 연결되어 있는 간선이 있는지 체크.
            for (int i=1; i<=n; i++) {
                for (int j : a[i]) {
                    if (color[i] == color[j]) {
                        ok = false;
                    }
                }
            }
	    // 같은 팀에 연결된 정점이 없다면
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}