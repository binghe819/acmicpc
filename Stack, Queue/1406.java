import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		// 처음에 커서의 위치는 가장 오른쪽이므로 left에 다 넣어준다.
		for(char ch : input.toCharArray()) {
			left.push(ch);
		}
		
		int num = Integer.parseInt(br.readLine()); // 명령어의 개수
		
		while(num-- > 0) {
			String[] command = br.readLine().split(" ");
			// 커서를 왼쪽으로 -> left의 top문자를 right으로 push
			if(command[0].equals("L")) {
				if(!left.isEmpty())
					right.push(left.pop());
			} 
			// 커서를 오른쪽으로 -> right의 top문자를 left에 push
			else if(command[0].equals("D")) {
				if(!right.isEmpty())
					left.push(right.pop());
			} 
			// 커서의 왼쪽 삭제 -> left의 top문자 pop
			else if(command[0].equals("B")) {
				if(!left.isEmpty())
					left.pop();
			} 
			// 커서의 왼쪽에 새로운 문자 입력 -> left에 새로운 문자 push
			else if(command[0].equals("P")) {
				left.push(command[1].charAt(0));
			}
		}
		
		// 출력을 위해서 left stack의 문자를 모두 right으로 옮기기
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		// 출력
		while(!right.isEmpty()) {
			System.out.print(right.pop());
		}
		
		return;
	}
}