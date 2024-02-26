import DB.Conect;
import Model.Avion;
import Service.AvionService;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        AvionService avionService = new AvionService();
        Conect.createTable();

        Avion charter1 = new Avion("Lan","LA745","123", new Date("2012-05-12"));

        avionService.registrar(charter1);

    }

}
