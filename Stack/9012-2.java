import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.nextLine();
		
		while(num-- > 0) {
			int cnt = 0; // Stack이 아닌 cnt를 통한 괄호 체크.
			String input = sc.next();
			boolean check = true;
            
			for(char ch : input.toCharArray()) {
				if(ch == '(') // 여는 괄호면 cnt 1추가
					cnt++;
				else // 닫는 괄호면 cnt 1빼기
					cnt--;
				if(cnt < 0) { // 만약 여는 괄호가 없다면.
					check = false;
					break;
				}
			}
			if(cnt != 0) // 만약 여는 괄호가 아직 남아있다면.
				check = false;
			System.out.println(check ? "YES" : "NO");
		}
		sc.close();
		return;
	}
}

