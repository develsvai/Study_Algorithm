import java.util.Scanner;

public class Main {
    static int maxCandyWidth = 1;
    static int N;
    static char[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        board = new char[N][N];

        // board 에 대한 NxN 입력
        for (int i = 0; i < N; i++) {
            String row = scanner.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = row.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(board, i, j, i, j + 1);
                search();
                swap(board, i, j + 1, i, j);
            }
        }

//         열을 기준으로 아래쪽 색과 변경
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(board,i, j, i + 1, j);
                search();
                swap(board,i + 1, j, i, j);
            }
        }

        System.out.println(maxCandyWidth);
    }

    public static void search() {
        //행에서 긴 수열 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                    maxCandyWidth = Math.max(count, maxCandyWidth);
                } else {
                    count = 1;
                }
            }
        }
        //열에서 긴 수열 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                    maxCandyWidth = Math.max(count, maxCandyWidth);
                } else {
                    count = 1;
                }
            }
        }
    }

    public static void swap(char[][] board,int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

}

