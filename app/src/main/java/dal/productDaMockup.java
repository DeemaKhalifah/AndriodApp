package dal;

import java.util.ArrayList;
import java.util.List;

public class productDaMockup {
    private static ArrayList<Product> products = new ArrayList<>();

    static {
        // Initialize only once
        products.add(new Product("chair", 50));
        products.add(new Product("bed", 5000));
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
