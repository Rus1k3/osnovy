import java.util.Scanner;

public class InvestmentCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальный вклад: ");
        double initialAmount = scanner.nextDouble();
        System.out.print("Введите число лет: ");
        int years = scanner.nextInt();
        System.out.print("Введите процентную ставку: ");
        double interestRate = scanner.nextDouble();

        for (int i = 1; i <= years; i++) {
            initialAmount += initialAmount * (interestRate / 100);
            System.out.printf("Через %d год(а) вы получите %.2f долларов.\n", i, initialAmount);
        }
    }
}
