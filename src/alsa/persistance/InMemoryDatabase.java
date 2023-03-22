package alsa.persistance;

import alsa.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements Database
{
    private final List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Optional<Product> getProductByName(String name) {
        for (Product product : products)
            if (product.getName().equals(name))
                return Optional.of(product);
        return Optional.empty();
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
