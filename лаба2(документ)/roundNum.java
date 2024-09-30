import java.util.Scanner; 

public class roundNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        double n = scanner.nextDouble();
        System.out.println("Округленное число: " + Math.round(n));
    }
}
