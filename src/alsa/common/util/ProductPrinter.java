package alsa.common.util;

import alsa.common.entity.Product;

import java.util.List;

public class ProductPrinter {
    public static void printProducts(List<Product> products){
        System.out.println("---------------------");
        for(Product product : products)
            System.out.println(product.toString());
        System.out.println("---------------------");
    }
}
