package Service;

import Implement.AvionDAO;
import Implement.IDao;
import Model.Avion;

public class AvionService {

    private IDao<Avion> avionIDao;

    public AvionService(){
        this.avionIDao = new AvionDAO();
    }

    // Insertar o registrar un avion
    public Avion registrar(Avion avion){
        return avionIDao.registrar(avion);
    }

    //Buscar por ID
    public Avion buscarXID(int id){
        return avionIDao.buscar(id);
    }

    // Eliminar registro
    public void eliminar(int id){
        avionIDao.eliminar(id);
    }
}
