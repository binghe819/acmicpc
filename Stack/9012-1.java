import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		Stack<Character> stack;
		sc.nextLine();
		
		while(num-- > 0) {
			boolean check = true;
			stack = new Stack<Character>();
			String input = sc.nextLine();
			for(char ch : input.toCharArray()) {
				if(ch == '(') { // 여는 괄호면 push
					stack.push(ch);
				} else if(ch == ')'){ // 닫는 괄호면
					if(stack.isEmpty()) { // 만약 스택이 비어있다면.
						check = false; // NO
						break;
					}
					stack.pop(); // 만약 스택이 비어있지 않다면 pop.
				}
			}
                        // 만약 모든 과정이 끝났는데 스택에 여는 괄호가 남아있다면
			if(!stack.isEmpty()) { 
				check = false;
			}
			System.out.println(check ? "YES" : "NO");
		}
		sc.close();
		return;
	}
}