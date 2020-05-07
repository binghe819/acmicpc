import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<Character>();
		int check = 0;
		
		String input = sc.nextLine();
		StringBuilder result = new StringBuilder();
		
		for(char ch : input.toCharArray()) {
			if(ch == '<') {
				check+=1;
				while(!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append("<");
			} else if(ch == '>') {
				check-=1;
				result.append(">");
			} else if(ch == ' ') {
				while(!stack.isEmpty())
					result.append(stack.pop());
				result.append(" ");
			} else {
				if(check == 0)
					stack.push(ch);
				else
					result.append(ch);
			}
		}
		
		// 스택에 남아있다면 모두 출력.
		while(!stack.isEmpty())
			result.append(stack.pop());
		
		System.out.println(result);
		sc.close();
		return;
	}
}
