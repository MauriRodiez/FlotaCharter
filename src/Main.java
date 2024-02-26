import DB.Conect;
import Model.Avion;
import Service.AvionService;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        AvionService avionService = new AvionService();
        Conect.createTable();

        Avion charter1 = new Avion("Lan","LA745","123", LocalDate.of(2015,8,11));
        Avion charter2 = new Avion("Iberia","727","1234", LocalDate.of(2016,2,21));

        avionService.registrar(charter1);
        avionService.registrar(charter2);

        avionService.buscarXID(1);

        avionService.eliminar(2);

    }

}
