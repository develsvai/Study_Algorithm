import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        ArrayList<Integer> cases = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            cases.add(scanner.nextInt());
        }

        ArrayList<Integer> triangularNumbers = generateTriangularNumbers(1000);

        for (int K : cases) {
            int result = canBeExpressedAsSumOfThreeTriangularNumbers(K, triangularNumbers);
            System.out.println(result);
        }

        scanner.close();
    }
    
    // 삼각수 계산
    public static ArrayList<Integer> generateTriangularNumbers(int limit) {
        ArrayList<Integer> triangularNumbers = new ArrayList<>();
        int n = 1;
        while (true) {
            int Tn = n * (n + 1) / 2;
            if (Tn > limit) {
                break;
            }
            triangularNumbers.add(Tn);
            n++;
        }
        return triangularNumbers;
    }

    // 3개 삼각수의 합
    public static int canBeExpressedAsSumOfThreeTriangularNumbers(int K, ArrayList<Integer> triangularNumbers) {
        int length = triangularNumbers.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    if (triangularNumbers.get(i) + triangularNumbers.get(j) + triangularNumbers.get(k) == K) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

}
