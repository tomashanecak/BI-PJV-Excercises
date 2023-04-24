package alsa.server;

import alsa.common.dto.CreateProductRequest;
import alsa.common.dto.CreateProductResponse;
import alsa.common.dto.ListProductsRequest;
import alsa.common.dto.ListProductsResponse;
import alsa.server.services.EshopService;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerWorker {

    private final Socket client;
    private final EshopService eshopService;

    public ServerWorker(Socket client, EshopService eshopService) {
        this.client = client;
        this.eshopService = eshopService;
    }

    public void start() {
        new Thread(this::work).start();
    }

    private void work() {
        try(ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream())
        ) {
            while (true) {
                Object requestObject = in.readObject();

                if (requestObject instanceof CreateProductRequest request) {
                    System.out.println("[WORKER]: Create product request");
                    eshopService.addProductsToStorage(request.getProduct());
                    out.writeObject(new CreateProductResponse());
                    out.flush();
                } else if (requestObject instanceof ListProductsRequest) {
                    System.out.println("[WORKER]: List products request");
                    out.writeObject(new ListProductsResponse(eshopService.getProducts()));
                    out.flush();
                } else {
                    System.err.println("[WORKER]: err, unknown request");
                }
            }
        } catch(EOFException e) {
            System.out.println("[WORKER]: Client ended the connection!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
