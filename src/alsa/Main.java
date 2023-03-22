package alsa;

import alsa.comparator.ProductNameComparator;
import alsa.comparator.ProductPriceComparator;
import alsa.entity.Product;
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

        EshopService eshopService = new EshopServiceImp(new InMemoryDatabase());
        eshopService.addProductsToStorage(lenovoE500, hpBusinnesPlus, samsungMediaPlus);

        printProducts(eshopService.getProducts());

        System.out.println("---------SELLING LENOVO------------");
        eshopService.sellProduct(lenovoE500.getName());
        eshopService.sellProduct(lenovoE500.getName());
        eshopService.sellProduct(lenovoE500.getName());

        System.out.println("---------SELLING SAMSUNG------------");
        eshopService.sellProduct(samsungMediaPlus.getName());

        System.out.println("---------RETURNING SAMSUNG------------");
        eshopService.returnProduct(samsungMediaPlus.getName());

        System.out.println("---------RETURNING LENOVO------------");
        eshopService.returnProduct(lenovoE500.getName());

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