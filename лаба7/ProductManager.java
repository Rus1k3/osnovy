

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Product {
    private String name;
    private int price;
    private double weight;

    public Product(String name, int price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Продукт{" +
                "Название='" + name + '\'' +
                ",Цена=" + price +
                ",Вес=" + weight +
                '}';
    }
}

enum ProductName {
    APPLE, BANANA, ORANGE, PINEAPPLE, GRAPE, CAPIBARA, KIWI, GOIDA, PEACH
}

public class ProductManager {
    public static void main(String[] args) {
        Random random = new Random();

        List<Product> cart = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String randomName = ProductName.values()[random.nextInt(ProductName.values().length)].name();
            int randomPrice = random.nextInt(15000);
            double randomWeight = Math.round((random.nextDouble() * 10) * 10.0) / 10.0;
            Product newProduct = new Product(randomName, randomPrice, randomWeight);

            if (!cart.stream().anyMatch(p -> p.getName().equals(newProduct.getName()))) {
                cart.add(newProduct);
            }
        }

        cart.removeIf(product -> product.getWeight() > 5 || product.getPrice() > 10000);

        Product favoriteProduct = new Product("GOIDA", 100, 1.0);
        cart.add(0, favoriteProduct);

        System.out.println("Продукты стоимостью < 10 и весом > 2:");
        cart.stream()
            .filter(product -> product.getPrice() < 10 && product.getWeight() > 2)
            .forEach(System.out::println);

        System.out.println("\nПолная корзина:");
        cart.forEach(System.out::println);
    }
}
