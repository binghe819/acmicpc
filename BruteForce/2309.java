import java.util.*;

// visited를 사용하는 푸는 방식.
public class Main {

    static int[] input;
    static boolean[] visited;

    public static void check(){
        int sum = 0;
        for(int i = 0; i < 8; i++){
            visited[i] = true;
            for(int j = i+1; j < 9; j++){
                visited[j] = true;
                for(int k = 0 ; k < 9; k++){
                    if(visited[k] == false)
                        sum+=input[k];
                }
                if(sum == 100)
                    return;
                visited[j] = false;
                sum = 0;
            }
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        input = new int[9];
        visited = new boolean[9];

        for(int i = 0; i < 9; i++)
            input[i] = sc.nextInt();

        check();

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            if(visited[i] == false)
                result.add(input[i]);
        }

        // 오름 차순
        Collections.sort(result);

        for(int i = 0; i < 7; i++)
            System.out.println(result.get(i));
        sc.close();
    }
}