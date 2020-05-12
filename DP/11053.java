import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        Integer[] memo = new Integer[N];

        for(int i = 0; i < N; i++)
            A[i] = sc.nextInt();

	// LIS ( 하나하나 확인 )
        for(int i = 0; i < N; i++){
            memo[i] = 1;
            for(int j = 0; j < i; j++){
                if(A[i] > A[j] && memo[i] < memo[j]+1){
                    memo[i] = memo[j]+1;
		    // max값을 지정하여 풀이도 가능하다.
                }
            }
        }

        // 내림차순
        Arrays.sort(memo, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(memo[0]);
        sc.close();
    }
}