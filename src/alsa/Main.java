package alsa;

import alsa.comparator.ProductNameComparator;
import alsa.comparator.ProductPriceComparator;
import alsa.entity.Product;
import alsa.persistance.FileDatabase;
import alsa.persistance.InMemoryDatabase;
import alsa.services.EshopService;
import alsa.services.EshopServiceImp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static alsa.util.SampleData.*;

public class Main {

    public static void printProducts(List<Product> products){
        System.out.println("---------------------");
        for(Product product : products)
            System.out.println(product.toString());
        System.out.println("---------------------");
    }

    public static List<Product> sortProducts(List<Product> products, Comparator<Product> comparator){
        products.sort(comparator);
        return products;
    }

    public static void main(String[] args) {

        EshopService eshopService = new EshopServiceImp(new FileDatabase());
        eshopService.addProductsToStorage(lenovoE500, hpBusinnesPlus, samsungMediaPlus);

        printProducts(eshopService.getProducts());

        System.out.println("---------SELLING LENOVO------------");
        eshopService.sellProduct(lenovoE500.getId());
        eshopService.sellProduct(lenovoE500.getId());
        eshopService.sellProduct(lenovoE500.getId());

        System.out.println("---------SELLING SAMSUNG------------");
        eshopService.sellProduct(samsungMediaPlus.getId());

        System.out.println("---------RETURNING SAMSUNG------------");
        eshopService.returnProduct(samsungMediaPlus.getId());

        System.out.println("---------RETURNING LENOVO------------");
        eshopService.returnProduct(lenovoE500.getId());

        System.out.println("---------SORT USING METHOD COMPARABLE------------");
        List<Product> products = eshopService.getProducts();
        Collections.sort(products);
        printProducts(products);

        System.out.println("---------SORT USING CLASS COMPARATOR------------");
        printProducts(sortProducts(products, new ProductNameComparator()));

        System.out.println("---------SORT USING CLASS COMPARATOR BY PRICE------------");
        printProducts(sortProducts(products, new ProductPriceComparator().reversed()));
    }
}