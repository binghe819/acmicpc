import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] arr = new int[num];
		int first = 0;
		int end = 0;
		
		while(num-- > 0) {
			String input = sc.next();
			
			if(input.equals("push")) {
				arr[end] = sc.nextInt();
				end++;
			} else if(input.equals("pop")) {
				if(first == end)
					System.out.println(-1);
				else {
					System.out.println(arr[first]);
					arr[first] = 0;
					first++;
				}
			} else if(input.equals("front")) {
				if(first == end)
					System.out.println(-1);
				else
					System.out.println(arr[first]);
			} else if(input.equals("back")) {
				if(first == end)
					System.out.println(-1);
				else
					System.out.println(arr[end-1]);
			} else if(input.equals("empty")) {
				if(first == end)
					System.out.println(1);
				else
					System.out.println(0);
			} else if(input.equals("size")) {
				System.out.println(end-first);
			}
		}
		sc.close();
		return;
	}
}