package alsa.services;

import alsa.entity.Product;
import alsa.persistance.Database;

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
    public boolean sellProduct(String name) {
        Product toSell = database.getProductByName(name);
        if (toSell == null || toSell.getCount() == 0)
            return false;
        database.saveProduct(toSell.withDecreasedCount());
        return true;
    }

    @Override
    public boolean returnProduct(String name) {
        Product toSell = database.getProductByName(name);
        if (toSell == null || !toSell.hasSpecialGuarantee())
            return false;
        database.saveProduct(toSell.withIncreasedCount());
        return true;
    }

    @Override
    public Product[] getProducts() {
        return database.getProducts();
    }
}
