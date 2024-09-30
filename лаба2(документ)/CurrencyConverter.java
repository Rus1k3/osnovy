import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество долларов: ");
        double dollars = scanner.nextDouble();

        double pounds = dollars / 1.487;
        double francs = dollars / 0.172;
        double marks = dollars / 0.584;
        double yen = dollars / 0.00955;

        System.out.printf("Эквивалент в фунтах: %.2f\n", pounds);
        System.out.printf("Эквивалент в франках: %.2f\n", francs);
        System.out.printf("Эквивалент в марках: %.2f\n", marks);
        System.out.printf("Эквивалент в йенах: %.2f\n", yen);
    }
}
