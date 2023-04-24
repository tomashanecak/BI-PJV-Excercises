package alsa.server;

import alsa.server.persistance.Database;
import alsa.server.persistance.InMemoryDatabase;
import alsa.server.services.EshopService;
import alsa.server.services.EshopServiceImp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {

    static public final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        Database db = new InMemoryDatabase();
        EshopService eshopService = new EshopServiceImp(db);

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("[SERVER]: Listening on port " + PORT);

        while(true) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("[SERVER]: New client joined!");
                new ServerWorker(client, eshopService).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
