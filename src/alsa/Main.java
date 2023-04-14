package alsa;

import alsa.comparator.ProductNameComparator;
import alsa.comparator.ProductPriceComparator;
import alsa.entity.Product;
import alsa.persistance.Database;
import alsa.persistance.FileDatabase;
import alsa.persistance.InMemoryDatabase;
import alsa.services.EshopService;
import alsa.services.EshopServiceImp;
import alsa.threads.BuyingCustomer;
import alsa.threads.Customer;
import alsa.threads.ProductReturningCustomer;

import java.util.Arrays;
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

        Database db = new InMemoryDatabase();
        //Database db = new FileDatabase();

        EshopService eshopService = new EshopServiceImp(db);

        // Uncomment if using InMemoryDB
        eshopService.addProductsToStorage(lenovoE500, hpBusinnesPlus, samsungMediaPlus);

        printProducts(eshopService.getProducts());

        /*
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
        */

        List<Customer> customers = Arrays.asList(
                new BuyingCustomer("B1", eshopService),
                new ProductReturningCustomer("R1", eshopService),
                new BuyingCustomer("B2", eshopService),
                new ProductReturningCustomer("R2", eshopService),
                new BuyingCustomer("B3", eshopService)
        );

        customers.forEach(Customer::start);
        sleep(10000);
        customers.forEach(Customer::stop);
        customers.forEach(Customer::join);
        customers.forEach(Customer::printStats);

        printProducts(eshopService.getProducts());
    }

    private static void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}