import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int size = 0;
		int[] stack = new int[num];
		for(int i = 0; i < num; i++) {
			String input = sc.next();
			
			if(input.equals("push")) {
				size++;
				stack[size] = sc.nextInt();
				
			} else if(input.equals("pop")) {
				if(size == 0)
					System.out.println(-1);
				else {
					System.out.println(stack[size]);
					stack[size] = 0;
					size--;
				}
				
			} else if(input.equals("top")) {
				if(size == 0)
					System.out.println(-1);
				else
					System.out.println(stack[size]);
				
			} else if(input.equals("size")) {
				System.out.println(size);
				
			} else if(input.equals("empty")) {
				if(size == 0)
					System.out.println(1);
				else
					System.out.println(0);
			}
		}
		sc.close();
		return;
	}
}