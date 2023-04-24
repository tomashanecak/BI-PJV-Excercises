package alsa.client;

import alsa.common.dto.CreateProductRequest;
import alsa.common.dto.CreateProductResponse;
import alsa.common.dto.ListProductsRequest;
import alsa.common.dto.ListProductsResponse;
import alsa.common.entity.Product;
import alsa.common.util.ProductPrinter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static alsa.common.util.SampleData.*;

public class ClientApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (Socket server = new Socket("localhost", 1234);
             ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(server.getInputStream());
        ) {
            createProduct(out, in, lenovoE500);
            createProduct(out, in, hpBusinnesPlus);
            createProduct(out , in, samsungMediaPlus);
            listProducts(out, in);
        }
    }

    private static void createProduct(ObjectOutputStream out, ObjectInputStream in , Product product)
            throws IOException, ClassNotFoundException
    {
        out.writeObject(new CreateProductRequest(product));
        out.flush();
        CreateProductResponse response = (CreateProductResponse)in.readObject();
        System.out.println("Created product ID " + product.getId());
    }

    private static void listProducts(ObjectOutputStream out, ObjectInputStream in)
            throws IOException, ClassNotFoundException
    {
        out.writeObject(new ListProductsRequest());
        out.flush();
        ListProductsResponse response = (ListProductsResponse)in.readObject();
        ProductPrinter.printProducts(response.getProducts());

    }
}
