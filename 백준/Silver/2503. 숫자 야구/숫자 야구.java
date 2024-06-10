import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[][] questions = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            questions[i][0] = scanner.nextInt();
            questions[i][1] = scanner.nextInt();
            questions[i][2] = scanner.nextInt();
        }
        
        List<String> possibleNumbers = generatePossibleNumbers();
        int count = 0;
        
        for (String number : possibleNumbers) {
            boolean isValid = true;
            for (int i = 0; i < N; i++) {
                int[] result = getStrikeAndBall(number, String.valueOf(questions[i][0]));
                if (result[0] != questions[i][1] || result[1] != questions[i][2]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }
        
        System.out.println(count);
        
        scanner.close();
    }
    
    private static List<String> generatePossibleNumbers() {
        List<String> possibleNumbers = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;
                for (int k = 1; k <= 9; k++) {
                    if (i == k || j == k) continue;
                    possibleNumbers.add("" + i + j + k);
                }
            }
        }
        
        return possibleNumbers;
    }
    
    private static int[] getStrikeAndBall(String number, String guess) {
        int strikes = 0;
        int balls = 0;
        
        for (int i = 0; i < 3; i++) {
            if (number.charAt(i) == guess.charAt(i)) {
                strikes++;
            } else if (number.contains(String.valueOf(guess.charAt(i)))) {
                balls++;
            }
        }
        
        return new int[]{strikes, balls};
    }
}
