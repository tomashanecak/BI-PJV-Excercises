package alsa.common.dto;

import alsa.common.entity.Product;

import java.io.Serializable;

public class CreateProductRequest implements Serializable {
    private final Product product;

    public CreateProductRequest(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
