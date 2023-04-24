package alsa.common.comparator;

import alsa.common.entity.Product;

import java.util.Comparator;

public class ProductPriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
