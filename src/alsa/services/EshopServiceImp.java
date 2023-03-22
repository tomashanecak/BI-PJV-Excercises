package alsa.services;

import alsa.entity.Product;
import alsa.persistance.Database;

import java.util.List;
import java.util.Optional;

public class EshopServiceImp implements EshopService{
    private final Database database;

    public EshopServiceImp(Database database) {
        this.database = database;
    }

    @Override
    public void addProductToStorage(Product product) {
        database.saveProduct(product);
    }

    @Override
    public void addProductsToStorage(Product... products) {
        for (Product product: products) {
            addProductToStorage(product);
        }
    }

    @Override
    public boolean sellProduct(int id) {
        Optional<Product> optionalProduct = database.getProductById(id);
        if (optionalProduct.isEmpty())
            return false;
        Product product = optionalProduct.get();
        if(product.getCount() == 0)
            return false;
        database.saveProduct(product.withDecreasedCount());
        return true;
    }

    @Override
    public boolean returnProduct(int id) {
        Optional<Product> optionalProduct = database.getProductById(id);
        if (optionalProduct.isEmpty())
            return false;
        Product product = optionalProduct.get();
        if(!product.hasSpecialGuarantee())
            return false;
        database.saveProduct(product.withIncreasedCount());
        return true;
    }

    @Override
    public List<Product> getProducts() {
        return database.getProducts();
    }
}
