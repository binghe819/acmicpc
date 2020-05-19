import java.util.*;

public class Main {

    public static int check(char[][] board){
        int count;
        int result = 0;
        int length = board.length;

        // 행과 열을 한번에 다 훑는 코드.
        for(int i = 0; i < length; i++){
            count = 1;
            // 행 확인
            for(int j = 1; j < length; j++){
                if(board[i][j] == board[i][j-1])
                    count++;
                else
                    count = 1;
                if(count > result)
                    result = count;
            }

            count = 1;
            // 열 확인
            for(int j = 1; j < length; j++){
                if(board[j][i] == board[j-1][i])
                    count++;
                else
                    count = 1;
                if(count > result)
                    result = count;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[][] board = new char[N][N];
        int result = 0;

        // 입력
        for(int i = 0; i < N; i++){
            String input = sc.next();
            for(int j = 0; j < N; j++){
                board[i][j] = input.charAt(j);
            }
        }

        char tmp;
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0; j < N; j++){

                // 오른쪽이랑 교환
                if(j+1 < N){
                    // 교환
                    tmp =  board[i][j];
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = tmp;

                    // 체크
                    count = check(board);
                    if(count > result)
                        result = count;

                    // 다시 되돌리기
                    tmp =  board[i][j];
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = tmp;
                }

                // 아래쪽이랑 교환
                if(i+1 < N){
                    // 교환
                    tmp = board[i][j];
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = tmp;

                    // 체크
                    count = check(board);
                    if(count > result)
                        result = count;

                    // 다시 되돌리기
                    tmp = board[i][j];
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = tmp;
                }
            }
        }

        System.out.println(result);

        sc.close();
    }
}