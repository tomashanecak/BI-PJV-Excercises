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
    public synchronized boolean sellProduct(int id) {
        Optional<Product> optionalProduct = database.getProductById(id);
        if (optionalProduct.isEmpty())
            return false;
        Product product = optionalProduct.get();
        while(product.getCount() == 0) {
            if(!product.hasSpecialGuarantee())
                return false;
            System.out.println("Waiting for product id: " + id);
            try {
                wait(); // Wait for notify
            } catch (InterruptedException e) {
                return false;
            }
            product = database.getProductById(id).get();
        }
        database.saveProduct(product.withDecreasedCount());
        return true;
    }

    @Override
    public synchronized boolean returnProduct(int id) {
        Optional<Product> optionalProduct = database.getProductById(id);
        if (optionalProduct.isEmpty())
            return false;
        Product product = optionalProduct.get();
        if(!product.hasSpecialGuarantee())
            return false;
        database.saveProduct(product.withIncreasedCount());
        notifyAll(); // Notifies all threads that product has been returned
        return true;
    }

    @Override
    public List<Product> getProducts() {
        return database.getProducts();
    }
}
