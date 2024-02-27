package Implement;

import Model.Avion;

import java.util.ArrayList;
import java.util.List;

public class AvionDAOmemory implements IDao<Avion>{

    private List<Avion> listadoAvionesRepo = new ArrayList<>();

    public AvionDAOmemory(List<Avion> listadoAvionesRepo) {
        this.listadoAvionesRepo = listadoAvionesRepo;
    }

    @Override
    public Avion registrar(Avion avion) {
        listadoAvionesRepo.add(avion);
        return avion;
    }

    @Override
    public Avion buscar(int id) {
        Avion avionBuscado = null;

        for(int i = 0; i < listadoAvionesRepo.size(); i++){
            Avion avion = listadoAvionesRepo.get(i);
            if(avion.getId() == id){
                avionBuscado = avion;
                return avionBuscado;
            }
        }
        return avionBuscado;
    }

    @Override
    public void eliminar(int id) {
        Avion avion = buscar(id);
        listadoAvionesRepo.remove(avion);
    }

    @Override
    public List<Avion> buscarTodos() {
        return listadoAvionesRepo;
    }
}
