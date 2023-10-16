import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        // 수 입력
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(numbers);

        // 정렬된 수 출력
        for (int i = 0; i < n; i++) {
            System.out.println(numbers[i]);
        }
    }
}
