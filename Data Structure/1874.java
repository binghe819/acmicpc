import java.util.*;


public class Main {

    static Scanner sc = new Scanner(System.in);

    public static StringBuilder solution(int n) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        int cnt = 0;

        while (n-- > 0) {
            int input = sc.nextInt();
            if (cnt < input) {
                while (cnt < input) {
                    stack.push(++cnt);
                    result.append("+\n");
                }
                stack.pop();
                result.append("-\n");
            } else { // (cnt >= input )
                boolean check = false;
                // 스택에서 계속해서 pop하면서 input찾기.
                while (!stack.isEmpty()) {
                    result.append("-\n");
                    // 만약 찾았다면.
                    if (stack.pop() == input){
                        check = true;
                        break;
                    }
                }
                // 만약 찾기 못했다면.
                if (!check) {
                    result.replace(0, result.length(), "NO");
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

}