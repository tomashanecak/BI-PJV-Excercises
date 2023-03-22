package alsa.services;

import alsa.entity.Product;

import java.util.List;

public interface EshopService {
    void addProductToStorage(Product product);
    void addProductsToStorage(Product... products);
    boolean sellProduct(String name);
    boolean returnProduct(String name);

    List<Product> getProducts();
}
