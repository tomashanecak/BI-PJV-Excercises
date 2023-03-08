package alsa;

import alsa.entity.Notebook;
import alsa.persistance.Database;
import alsa.services.EshopService;
import alsa.services.EshopServiceImp;

import static alsa.entity.NotebookCategory.*;

public class Main {
    public static void main(String[] args) {
        /*
        Notebook lenovo = new Notebook("Lenovo Yoga", BASIC, 10000);
        Notebook hp = new Notebook("HP Business", PROFESIONAL, 40000);
        Notebook dell = new Notebook("Dell XP", GAMING, 30000);
        Notebook asus = new Notebook("Asus ROG", GAMING, -35000);


        Notebook[] notebooks = new Notebook[] {lenovo, hp, dell, asus};
        for (Notebook notebook: notebooks) {
            System.out.printf("%s %s %d\n", notebook.getName(), notebook.getCategory().toString(), notebook.getPrice());
        }*/

        EshopService eshop = new EshopServiceImp(Database.DUMMY_DATABASE);



    }
}