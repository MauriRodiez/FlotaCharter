import DB.Conect;
import Implement.AvionDAOH2;
import Model.Avion;
import Service.AvionService;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        AvionService avionService = new AvionService();
        Conect.createTable();

        Avion charter1 = new Avion("Lan","LA745","123", LocalDate.of(2015,8,11));
        Avion charter2 = new Avion("Iberia","727","1234", LocalDate.of(2016,2,21));
        Avion charter3 = new Avion("TAM","737","12345", LocalDate.of(2011,7,15));
        Avion charter4 = new Avion("Air Europa","b727","12346", LocalDate.of(2016,11,25));
        Avion charter5 = new Avion("AmericaN","747","12347", LocalDate.of(2018,4,23));

        avionService.registrar(charter1);
        avionService.registrar(charter2);
        avionService.registrar(charter3);
        avionService.registrar(charter4);
        avionService.registrar(charter5);

        avionService.buscarXID(1);
        //avionService.buscarTodos();
        avionService.eliminar(2);

        avionService.buscarTodos();

    }

}
