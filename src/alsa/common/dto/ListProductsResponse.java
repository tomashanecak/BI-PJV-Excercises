package alsa.common.dto;

import alsa.common.entity.Product;

import java.io.Serializable;
import java.util.List;

public class ListProductsResponse implements Serializable {
    private final List<Product> products;

    public ListProductsResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
