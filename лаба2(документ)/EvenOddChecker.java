import java.util.Scanner;

public class EvenOddChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        if (n % 2 == 0) {
            System.out.println("ДА");
        } else {
            System.out.println("НЕТ");
        }
    }
}
