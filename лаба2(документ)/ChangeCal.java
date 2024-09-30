import java.util.Scanner;


public class ChangeCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите стоимость товара (рубли и копейки): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.print("Введите уплаченную сумму (рубли и копейки): ");
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int totalPrice = a * 100 + b;
        int totalPaid = c * 100 + d;
        int change = totalPaid - totalPrice;

        int rubles = change / 100;
        int kopecks = change % 100;

        System.out.printf("Сдача: %d руб. и %d коп.\n", rubles, kopecks);
    }
}
