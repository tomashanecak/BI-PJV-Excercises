package alsa.services;

import alsa.entity.Product;

import java.util.List;

public interface EshopService {
    void addProductToStorage(Product product);
    void addProductsToStorage(Product... products);
    boolean sellProduct(int id);
    boolean returnProduct(int id);

    List<Product> getProducts();
}
