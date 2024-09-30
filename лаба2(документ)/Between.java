
import java.util.Scanner;

public class Between {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число 1");
        int a = scanner.nextInt();
        System.out.print("Введите число 2");
        int b = scanner.nextInt();

        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
