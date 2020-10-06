import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine(); // 후위표기식
        double[] nums = new double[N];
	// 피연산자 입력
        for(int i = 0; i < N; i++){
            nums[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(char ch : input.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                stack.push(nums[ch-'A']);
            } else {
                double right = stack.pop();
                double left = stack.pop();
                if(ch == '+')
                    stack.push(left+right);
                else if(ch == '-')
                    stack.push(left-right);
                else if(ch == '*')
                    stack.push(left*right);
                else if(ch == '/')
                    stack.push(left/right);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}