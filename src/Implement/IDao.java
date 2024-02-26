package Implement;

import java.util.List;

public interface IDao<T> {

    //Registrar un nuevo avion
    T registrar(T t);

    // Buscar un avio por ID
    T buscar(T t);

    // Eliminar un avion por ID
    void eliminar(int id);

    // Buscar todos los aviones
    List<T> buscarTodos();
}
