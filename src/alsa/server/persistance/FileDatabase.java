package alsa.server.persistance;

import alsa.common.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileDatabase implements Database {

    static private final String FILE = "alsa.db";

    @Override
    public List<Product> getProducts() {
        return LoadProducts();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        List<Product> products = getProducts();
        for(Product product : products){
            if(product.getId() == id)
                return Optional.of(product);
        }
        return Optional.empty();
    }

    @Override
    public void saveProduct(Product product) {
        List<Product> products = getProducts();
        products.removeIf(productInDB -> productInDB.getId() == product.getId());
        products.add(product);
        PersistProducts(products);
    }

    @Override
    public void removeProduct(Product product) {
        List<Product> products = getProducts();
        products.removeIf(productInDB -> productInDB.getId() == product.getId());
        PersistProducts(products);
    }

    private List<Product> LoadProducts() {
        try (
                FileInputStream in = new FileInputStream(FILE);
                ObjectInputStream oIn = new ObjectInputStream(in)
        ) {
            List<Product> products = (List<Product>)oIn.readObject();
            return products == null ? new ArrayList<>() : products;
        } catch (Exception e) {
            System.err.println("There was an error reading from a database!");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void PersistProducts(List<Product> products) {
        try (
                FileOutputStream out = new FileOutputStream(FILE);
                ObjectOutputStream oOut = new ObjectOutputStream(out)
        ) {
            oOut.writeObject(products);
            oOut.flush();
        } catch (Exception e) {
            System.err.println("There was an error writing to a database!");
            e.printStackTrace();
        }
    }
}
