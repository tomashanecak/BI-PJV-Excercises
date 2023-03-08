package alsa.persistance;
import alsa.entity.Product;

public interface Database {
    Product[] getProducts();
    Product getProductByName(String name);
    void saveProduct(Product product);
    void removeProduct(Product product);

    public static final Database DUMMY_DATABASE = new Database() {
        @Override
        public Product[] getProducts() {
            return new Product[0];
        }

        @Override
        public Product getProductByName(String name) {
            return null;
        }

        @Override
        public void saveProduct(Product product) {

        }

        @Override
        public void removeProduct(Product product) {

        }
    };
}
