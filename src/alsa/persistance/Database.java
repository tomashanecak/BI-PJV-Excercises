package alsa.persistance;
import alsa.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface Database {
    List<Product> getProducts();
    Optional<Product> getProductByName(String name);
    void saveProduct(Product product);
    void removeProduct(Product product);

    public static final Database DUMMY_DATABASE = new Database() {
        @Override
        public List<Product> getProducts() {
            return Collections.emptyList();
        }

        @Override
        public Optional<Product> getProductByName(String name) {
            return Optional.empty();
        }

        @Override
        public void saveProduct(Product product) {

        }

        @Override
        public void removeProduct(Product product) {

        }
    };
}
