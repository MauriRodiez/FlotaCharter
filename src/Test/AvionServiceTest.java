package Test;

import Implement.AvionDAOmemory;
import Model.Avion;
import Service.AvionService;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvionServiceTest {
    private static AvionService  avionService = new AvionService();

    @Test
    public void InsertarAvion(){
        Avion avion = new Avion("test","test1","test1.1", LocalDate.of(2012,12,5));

        avionService.registrar(avion);
        avionService.eliminar(1);

        Assert.assertNotNull(avionService);

    }
}
