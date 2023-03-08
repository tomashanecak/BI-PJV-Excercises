package alsa.persistance;

import alsa.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements Database
{
    private final List<Product> products = new ArrayList<>();

    @Override
    public Product[] getProducts() {
        return new Product[0];
    }

    @Override
    public Product getProductByName(String name) {
        for (Product product : products)
            if (product.getName().equals(name))
                return product;
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        products.removeIf(existingProduct -> existingProduct.getName().equals(product.getName()));
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }
}
