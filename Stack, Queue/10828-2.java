import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < num; i++) {
			String input = sc.next();
			
			if(input.equals("push")) {
				stack.push(sc.nextInt());
				
			} else if (input.equals("pop")) {
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
				
			} else if (input.equals("top")) {
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
				
			} else if (input.equals("size")) {
				System.out.println(stack.size());
				
			} else if (input.equals("empty")) {
				if(stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
		
		sc.close();
		return;
	}
}