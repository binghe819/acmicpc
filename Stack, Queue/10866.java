import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		
		while(num-- > 0) {
			String input = sc.next();
			
			if(input.equals("push_front")) {
				deque.offerFirst(sc.nextInt());
			} else if(input.equals("push_back")) {
				deque.offerLast(sc.nextInt());
			} else if(input.equals("pop_front")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.pollFirst());
			} else if(input.equals("pop_back")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.pollLast());
			} else if(input.equals("size")) {
				System.out.println(deque.size());
			} else if(input.equals("empty")) {
				if(deque.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			} else if(input.equals("front")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekFirst());
			} else if(input.equals("back")) {
				if(deque.isEmpty())
					System.out.println(-1);
				else
					System.out.println(deque.peekLast());
			}
		}
		
		sc.close();
		return;
	}
}
