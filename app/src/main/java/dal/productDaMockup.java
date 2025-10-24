package dal;

import java.util.ArrayList;
import java.util.List;

public class productDaMockup {
    private static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product("Chair", 50, 10));
        products.add(new Product("Bed", 5000, 5));
        products.add(new Product("iPhone 14", 1200, 15));
        products.add(new Product("Samsung Galaxy S23", 1000, 20));
        products.add(new Product("iPad Pro", 900, 12));
        products.add(new Product("Samsung Galaxy Tab S8", 750, 8));
        products.add(new Product("Dell Laptop", 1500, 7));
        products.add(new Product("HP Laptop", 1300, 10));
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
