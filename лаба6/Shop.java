
public class Shop {
    private int numberOfCashiers;
    private Product[] products;
    private int numberOfSellers;

    // Вложенный класс Товар
    public static class Product {
        private double weight;
        private double price; 

        public Product() {
            this(0.0, 0.0);
        }

        public Product(double weight, double price) {
            this.weight = weight;
            this.price = price;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    public Shop() {
        this(1, new Product[0], 1);
    }

    public Shop(int numberOfCashiers, Product[] products, int numberOfSellers) {
        this.numberOfCashiers = numberOfCashiers;
        this.products = products;
        this.numberOfSellers = numberOfSellers;
    }

    public int getNumberOfCashiers() {
        return numberOfCashiers;
    }

    public void setNumberOfCashiers(int numberOfCashiers) {
        this.numberOfCashiers = numberOfCashiers;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getNumberOfSellers() {
        return numberOfSellers;
    }

    public void setNumberOfSellers(int numberOfSellers) {
        this.numberOfSellers = numberOfSellers;
    }

    public double calculateAverageProductWeight() {
        double totalWeight = 0.0;
        for (Product product : products) {
            totalWeight += product.getWeight();
        }
        return products.length > 0 ? totalWeight / products.length : 0.0;
    }

    public double calculateCashierEfficiency() {
        return numberOfCashiers > 0 ? (double) numberOfSellers / numberOfCashiers : 0.0;
    }

    public double calculateShopEfficiency() {
        double avgWeight = calculateAverageProductWeight();
        double cashierEfficiency = calculateCashierEfficiency();
        return avgWeight > 0 ? cashierEfficiency / avgWeight : 0.0;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "numberOfCashiers=" + numberOfCashiers +
                ", numberOfSellers=" + numberOfSellers +
                ", averageProductWeight=" + calculateAverageProductWeight() +
                ", cashierEfficiency=" + calculateCashierEfficiency() +
                ", shopEfficiency=" + calculateShopEfficiency() +
                '}';
    }
}

// Класс Супермаркет
public class laba6 extends Shop {
    private double shopArea;
    private String[] categories;

    // Конструкторы
    public laba6() {
        this(0.0, new String[0]);
    }

    public laba6(double shopArea, String[] categories) {
        super();
        this.shopArea = shopArea;
        this.categories = categories;
    }

    public laba6(int numberOfCashiers, Product[] products, int numberOfSellers, double shopArea, String[] categories) {
        super(numberOfCashiers, products, numberOfSellers);
        this.shopArea = shopArea;
        this.categories = categories;
    }

    public double getShopArea() {
        return shopArea;
    }

    public void setShopArea(double shopArea) {
        this.shopArea = shopArea;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    @Override
    public double calculateShopEfficiency() {
        double cashierEfficiency = calculateCashierEfficiency();
        return categories.length > 0 ? (shopArea / categories.length) * cashierEfficiency : 0.0;
    }

    @Override
    public String toString() {
        return "Supermarket{" +
                "shopArea=" + shopArea +
                ", categories=" + String.join(", ", categories) +
                ", shopEfficiency=" + calculateShopEfficiency() +
                '}';
    }
}
