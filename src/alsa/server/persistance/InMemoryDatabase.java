package alsa.server.persistance;

import alsa.common.entity.Product;

import java.util.*;

public class InMemoryDatabase implements Database
{
    private final Map<Integer, Product> products = new HashMap<>();

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public void saveProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product.getId());
    }
}
