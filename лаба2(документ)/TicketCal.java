import java.util.Scanner;

public class TicketCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество поездок: ");
        int n = scanner.nextInt();

        int count60 = n / 60;
        n %= 60;
        int count20 = n / 20;
        n %= 20;
        int count10 = n / 10;
        n %= 10;
        int count5 = n / 5;
        int count1 = n % 5;

        System.out.printf("%d %d %d %d %d\n", count1, count5, count10, count20, count60);
    }
}
