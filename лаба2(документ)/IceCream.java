import java.util.Scanner;

public class IceCream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество шариков: ");
        int k = scanner.nextInt();

        if (k % 3 == 0 || k % 5 == 0 || (k % 3 == 2 && k >= 5)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
