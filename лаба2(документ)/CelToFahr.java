import java.util.Scanner;

public class CelToFahr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите температуру в градусах Цельсия");
        double celsius = scanner.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.printf("Эквивалент по Фаренгейту%.2f\n", fahrenheit);
    }
}
