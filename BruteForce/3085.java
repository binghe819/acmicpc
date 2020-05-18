import java.util.*;

public class Main {

    public static int check(char[][] input){
        int n = input.length;
        int answer = 1;

        for(int i = 0; i < n; i++){
            int count = 1;

            for(int j = 1; j < n; j++){
                if(input[i][j] == input[i][j-1])
                    count+=1;
                else
                    count = 1;
                if(answer < count)
                    answer = count;
            }
            count = 1;
            for(int j = 1; j < n; j++){
                if(input[j][i] == input[j-1][i])
                    count+=1;
                else
                    count = 1;
                if(answer < count)
                    answer = count;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][] input = new char[n][n];

        for(int i = 0; i < n ; i++){
            String tmp = sc.next();
            for(int j = 0; j < n; j++){
                input[i][j] = tmp.charAt(j);
            }
        }

        char temp;
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j+1 < n){
                    // swap
                    temp = input[i][j];
                    input[i][j] = input[i][j+1];
                    input[i][j+1] = temp;

                    // check
                    int check = check(input);
                    if(result < check)
                        result = check;

                    // swap ( 원상복귀 )
                    temp = input[i][j];
                    input[i][j] = input[i][j+1];
                    input[i][j+1] = temp;
                }

                if(i+1 < n){
                    // swap
                    temp = input[i][j];
                    input[i][j] = input[i+1][j];
                    input[i+1][j] = temp;

                    // check
                    int check = check(input);
                    if(result < check)
                        result = check;

                    // swap ( 원상 복귀 )
                    temp = input[i][j];
                    input[i][j] = input[i+1][j];
                    input[i+1][j] = temp;
                }
            }
        }

        System.out.println(result);
        sc.close();
    }
}